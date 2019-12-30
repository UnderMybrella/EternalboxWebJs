import jquery.*
import jqueryui.changeFunc
import jqueryui.slideFunc
import org.w3c.dom.HTMLFormElement
import org.w3c.xhr.FormData
import org.w3c.xhr.ProgressEvent
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document
import kotlin.browser.window
import kotlin.contracts.ExperimentalContracts
import kotlin.js.Date.Companion.now
import kotlin.js.Json
import kotlin.js.json
import kotlin.math.*

@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
class Jukebox {
    var remixer: dynamic = null
    var player: dynamic = null
    lateinit var driver: JukeboxDriver
    var track: dynamic = null
    var width = 900
    var height = 680
    lateinit var paper: RaphaelPaper

    //configs for chances to branch
    var defaultMinRandomBranchChance = 0.18
    var defaultMaxRandomBranchChance = 0.5

    var defaultRandomBranchChanceDelta = 0.018
    var minRandomBranchChanceDelta = 0.000
    var maxRandomBranchChanceDelta = 0.200

    var highlightColour = "#0000FF"
    var jumpHighlightColour = "#00FF22"
    var selectColour = "#FF0000"
    var uploadingAllowed = false
    var debugMode = true
    var fastMode = false

    var shifted = false
    var controlled = false

    var minTileWidth = 10
    var maxTileWidth = 90
    var growthPerPlay = 10
    var curGrowFactor = 1

    var jukeboxData = JukeboxData(
        jukebox = this,

        infiniteMode = true,
        maxBranches = 4,
        maxBranchThreshold = 80,

        computedThreshold = 0,
        currentThreshold = 0,
        addLastEdge = true,
        justBackwards = false,
        justLongBranches = false,
        removeSequentialBranches = false,

        deletedEdgeCount = 0,

        lastBranchPoint = 0,
        longestReach = 0,

        beatsPlayed = 0,
        totalBeats = 0,
        branchCount = 0,

        selectedTile = null,
        selectedCurve = null,

        tiles = ArrayList(),
        allEdges = ArrayList(),
        deletedEdges = ArrayList(),

        audioUrl = null,
        trackID = null,
        ogAudioUrl = null,

        minRandomBranchChance = defaultMinRandomBranchChance,
        maxRandomBranchChance = defaultMaxRandomBranchChance,
        randomBranchChanceDelta = defaultRandomBranchChanceDelta,
        curRandomBranchChance = 0.0,
        lastThreshold = 0,

        tuningOpen = false,
        disableKeys = false,

        minLongBranch = 0
    )

    fun showInfo(s: String) {
        jQuery("#info").text(s)
    }

    fun showError(s: String) {
        val errorElement = jQuery("#error")
        if (s.isBlank()) {
            errorElement.hide()
        } else {
            errorElement.text(s)
            errorElement.show()
        }
    }

    fun setDisplayMode(playMode: Boolean) {
        if (playMode) {
            jQuery("#song-div").hide()
            jQuery("#select-track").hide()
            jQuery("#running").show()
            jQuery(".rotate").hide()
        } else {
            jQuery("#song-div").show()
            jQuery("#select-track").show()
            jQuery("#running").hide()
            jQuery(".rotate").show()
        }

        showInfo("")
    }

    fun hideAll() {
        jQuery("#song-div").hide()
        jQuery("#select-track").hide()
        jQuery("#running").hide()
        jQuery(".rotate").hide()
    }

    fun stop() {
        player.stop()
        player = remixer.getPlayer()
    }

    fun createTiles(qtype: String) = createTileCircle(qtype, 250)
    fun createTileCircle(qtype: String, radius: Int): Array<JukeboxTile> {
        var start = now()
        val yPadding = 90
        val xPadding = 200
        val maxWidth = 90
        val tiles: MutableList<dynamic> = ArrayList()
        val qlist = track[qtype]
        val n = qlist.length as Double
        var r = radius.toDouble()
        val alpha = PI * 2.0 / n
        val perimeter = 2.0 * n * r * sin(alpha / 2.0)
        val a = perimeter / n
        var width = a * 20
        val angleOffset = -PI / 2.0

        if (width > maxWidth)
            width = maxWidth.toDouble()

        width = minTileWidth.toDouble()

        paper.clear()

        var angle = angleOffset
        for (i in 0 until qlist.length as Int) {
            val tile = createNewTile(i, qlist[i], a, width)
            val y = yPadding + r + r * sin(angle)
            val x = xPadding + r + r * cos(angle)
            tile.move(x, y)
            tile.rotate(angle)
            tiles.add(tile)
            angle += alpha
        }

        // now connect every tile to its neighbors

        // a horrible hack until I figure out
        // geometry
        // sic. Paul Lamere

        val rOffset = width / 2.0
        val yOffset = width * 0.52
        val xOffset = width * 1.0
        val center = " S 450 350 "
        var branchCount = 0
        r -= rOffset
        for (i in tiles.indices) {
            val startAngle = alpha * i + angleOffset
            val tile = tiles[i]
            val y1 = yPadding + r + r * sin(startAngle) + yOffset
            val x1 = xPadding + r + r * cos(startAngle) + xOffset

            for (j in 0 until tile.q.neighbors.length as Int) {
                val destAngle = alpha * (tile.q.neighbors[j].dest.which as Int) + angleOffset
                val y2 = yPadding + r + r * sin(destAngle) + yOffset
                val x2 = xPadding + r + r * cos(destAngle) + xOffset

                val path = "M$x1 $y1$center$x2 $y2"
                val curve = paper.path(path)
                curve.data("edge", tile.q.neighbors[j])
                addCurveClickHandler(curve)
                highlightCurve(curve, false, false)
                tile.q.neighbors[j].curve = curve
                branchCount++
            }
        }

        jukeboxData.branchCount = branchCount
        return tiles.toTypedArray()
    }

    fun addCurveClickHandler(curve: dynamic) {
        curve.click = {
            if (jukeboxData.selectedCurve) {
                highlightCurve(jukeboxData.selectedCurve, false, false)
            }

            selectCurve(curve)
            jukeboxData.selectedCurve = curve
        }

        curve.mouseover = {
            highlightCurve(curve, true, false)
        }

        curve.mouseout = {
            if (curve != jukeboxData.selectedCurve) {
                highlightCurve(curve, false, false)
            }
        }
    }

    fun highlightCurve(curve: dynamic, enable: Boolean, jump: Boolean) {
        if (curve) {
            if (enable) {
                val colour = if (jump) jumpHighlightColour else highlightColour
                curve.attr("stroke-width", 4)
                curve.attr("stroke", colour)
                curve.attr("stroke-opacity", 1.0)
                curve.toFront()
            } else {
                if (curve.edge) {
                    curve.attr("stroke-width", 3)
                    curve.attr("stroke", curve.edge.src.tile.quantumColour)
                    curve.attr("stroke-opacity", 0.7)
                }
            }
        }
    }

    fun selectCurve(curve: dynamic) {
        curve.attr("stroke-width", 6)
        curve.attr("stroke", selectColour)
        curve.attr("stroke-opacity", 1.0)
        curve.toFront()
    }

    fun extractTitle(url: String): String {
        val lastSlash = url.lastIndexOf('/')
        return if (lastSlash >= 0 && lastSlash < url.length - 1) {
            url.substring(lastSlash + 1, url.length - 4)
        } else {
            url
        }
    }

    fun getTitle(title: String?, artist: String?, url: String?): String? {
        var res: String? = title
        if (title == null || title.isBlank() || title == "(unknown title)" || title == "undefined") {
            if (url != null) {
                res = extractTitle(url)
            } else {
                res = null
            }
        } else if (artist != null && artist != "(unknown artist)") {
            res = "$title by $artist"
        }

        return res
    }

    fun trackReady(t: dynamic) {
        document.title = "EternalBox for ${t.fixedTitle}"
        jQuery("#song-title").text(t.fixedTitle as String)
        jQuery("#song-url").attr("href", "https://open.spotify.com/track/${jukeboxData.trackID}")
        jukeboxData.minLongBranch = track.beats.length as Int / 5
    }

    fun readyToPlay(t: dynamic) {
        setDisplayMode(true)
        driver = JukeboxDriver(this)
        showInfo("Ready!")
        normaliseColour()
        trackReady(t)
        drawVisualisation()
    }

    fun drawVisualisation() {
        if (track) {
            if (jukeboxData.currentThreshold == 0) {
                dynamicCalculateNearestNeighbours("beats")
            } else {
                calculateNearestNeighbours("beats", jukeboxData.currentThreshold)
            }

            createTilePanel("beats")
        }
    }

    fun gotTheAnalysis(profile: EternalboxAnalysis) {
        showInfo("Loading track...")
        remixer.remixTrack(profile, jukeboxData) { state: dynamic, t: dynamic, _percent: Double ->
            track = t
            val percent = _percent.coerceIn(0.0, 100.0)

            if (state == 1) {
                showInfo("Calculating pathways through the song...")
                window.setTimeout({
                    readyToPlay(t)
                }, 10)
            } else if (state == 0) {
                if (percent >= 99) {
                    showInfo("Calculating pathways through the song... (pre-emptively)")
                } else {
                    if (percent > 0) {
                        showInfo("$percent% of track loaded")
                    } else {
                        showInfo("Loading the track")
                    }
                }
            } else {
                showInfo("Trouble ${t.status}")
                setDisplayMode(false)
            }
        }
    }

    fun listSong(r: dynamic): JQuery? {
        val title = getTitle(r.title, r.artist, null)
        if (title != null) {
            val item = jQuery("<li>").append(title)

            item.attr("class", "song-link")
            item.click { showPlotPage(r.id) }

            return item
        }

        return null
    }

    fun listSongAsAnchor(r: dynamic): JQuery {
        var title = getTitle(r.title, r.artist, r.url)
        return jQuery("<li>").html("<a href=index.html?id=${r.id}>$title</a>")
    }

    fun listTracks(active: String, tracks: Array<dynamic>) {
        val songsList = jQuery("%songs-list")
        jQuery("#songs-div").show()
        songsList.empty()
        jQuery(".sel-list").removeClass("activated")
        jQuery(active).addClass("activated")
        for (i in tracks.indices) {
            val s = tracks[i]
            val item = listSong(s)
            if (item != null) {
                songsList.append(item)
            }
        }
    }

    val ANALYSIS_URL: String = jQuery("#analysis-url")
        .attr("content")
        .takeIf { it != undefined }
        ?: "http://localhost:9090/api/analysis"

    fun fetchAnalysis(id: String) {
        val url = "$ANALYSIS_URL/spotify/$id"
        showInfo("Fetching the analysis")

        val analysisGetXhr = ajax {
            this.url = url
            dataType = "json"
            type = "GET"
            crossDomain = true
        }

        analysisGetXhr.then<dynamic>({ data: Any, _: String, _: JQueryXHR ->
            println("Analysis: ${JSON.stringify(data)}")
            gotTheAnalysis(EternalboxAnalysis(data as Json))
        }, { jqXHR: JQueryXHR, _: String, _: Any ->
            if (jqXHR.status.toInt() == 404) {
                val analysisPutXhr = ajax {
                    this.url = url
                    dataType = "json"
                    type = "PUT"
                    crossDomain = true
                }

                analysisPutXhr.then<dynamic>({ data: Any, _: String, _: JQueryXHR ->
                    gotTheAnalysis(EternalboxAnalysis(data as Json))
                }, { _, textStatus, errorThrown ->
                    showInfo("Sorry, can't find info for that track: $textStatus ($errorThrown)")
                })
            }
        })
    }

    fun calculateDim(numTiles: Int, totalWidth: Int, totalHeight: Int): Double {
        val area = totalWidth * totalHeight
        val tArea = area.toDouble() / (1.2 * numTiles.toDouble())
        return floor(sqrt(tArea))
    }

    var timbreWeight = 1.0
    var pitchWeight = 10.0
    var loudStartWeight = 1.0
    var loudMaxWeight = 1.0
    var durationWeight = 100.0
    var confidenceWeight = 1.0

    fun getSegDistances(seg1: dynamic, seg2: dynamic): Double {
        var timbre = segDistance(seg1, seg2, "timbre", true)
        var pitch = segDistance(seg1, seg2, "pitches", false)
        val sloudStart = 1.0 //abs(seg1.loudness_start - seg2.loudness_start)
        val sloudMax = 1.0 //abs(seg1.loudness_max - seg2.loudness_max)
        val duration = 1.0 //abs(seg1.duration - seg2.duration)
        val confidence = 1.0 //abs(seg1.confidence - seg2.confidence)
        return timbre * timbreWeight + pitch * pitchWeight + sloudStart * loudStartWeight + sloudMax * loudMaxWeight + duration * durationWeight + confidence * confidenceWeight
    }

    fun dynamicCalculateNearestNeighbours(type: String): Int {
        var count = 0
        var targetBranchCount = (track[type].length as Int) / 6

        precalculateNearestNeighbours(type, jukeboxData.maxBranches, jukeboxData.maxBranchThreshold)

        var threshold = 10
        while (threshold < jukeboxData.maxBranchThreshold) {
            count = collectNearestNeighbours(type, threshold)
            if (count >= targetBranchCount)
                break
            threshold += 5
        }

        jukeboxData.computedThreshold = threshold
        jukeboxData.currentThreshold = threshold
        postProcessNearestNeighbours(type)
        return count
    }

    fun postProcessNearestNeighbours(type: String) {
        removeDeletedEdges()

        if (jukeboxData.addLastEdge) {
            if (longestBackwardBranch(type) < 50) {
                insertBestBackwardBranch(type, jukeboxData.currentThreshold, 65)
            } else {
                insertBestBackwardBranch(type, jukeboxData.currentThreshold, 55)
            }
        }

        calculateReachability(type)
        jukeboxData.lastBranchPoint = findBestLastBeat(type)
        filterOutBadBranches(type, jukeboxData.lastBranchPoint)
        if (jukeboxData.removeSequentialBranches) {
            filterOutSequentialBranches(type)
        }
        setTunedUrl()
    }

    fun removeDeletedEdges() {
        for (i in jukeboxData.deletedEdges.indices) {
            val edgeID = jukeboxData.deletedEdges[i] as Int //Should be right
            if (edgeID in jukeboxData.allEdges.indices) {
                val edge = jukeboxData.allEdges[edgeID]
                deleteEdge(edge)
            }
        }

        jukeboxData.deletedEdges.clear()
    }

    fun getAllDeletedEdgeIDs(): IntArray {
        var results: MutableList<Int> = ArrayList()
        jukeboxData.allEdges.forEach { edge ->
            if (edge.deleted) {
                results.add(edge.id)
            }
        }

        return jukeboxData.allEdges
            .filter(JukeboxEdge::deleted)
            .toIntArray(JukeboxEdge::id)
    }

    fun calculateNearestNeighbours(type: String, threshold: Int): Int {
        precalculateNearestNeighbours(type, jukeboxData.maxBranches, jukeboxData.maxBranchThreshold)
        val count = collectNearestNeighbours(type, threshold)
        postProcessNearestNeighbours(type) //, threshold
        return count
    }

    fun resetTuning() {
        undeleteAllEdges()

        jukeboxData.addLastEdge = true
        jukeboxData.justBackwards = false
        jukeboxData.justLongBranches = false
        jukeboxData.removeSequentialBranches = false
        jukeboxData.currentThreshold = jukeboxData.computedThreshold
        jukeboxData.minRandomBranchChance = defaultMinRandomBranchChance
        jukeboxData.maxRandomBranchChance = defaultMaxRandomBranchChance
        jukeboxData.randomBranchChanceDelta = defaultRandomBranchChanceDelta

        jukeboxData.minRandomBranchChance = defaultMinRandomBranchChance
        jukeboxData.maxRandomBranchChance = defaultMaxRandomBranchChance
        jukeboxData.randomBranchChanceDelta = defaultRandomBranchChanceDelta
        jukeboxData.audioUrl = null
        jukeboxData.disableKeys = false

        drawVisualisation()
    }

    fun undeleteAllEdges() {
        jukeboxData.deletedEdgeCount = 0
        jukeboxData.allEdges.forEach { edge -> edge.deleted = false }
    }

    fun setTunedUrl() {
        if (track) {
            val edges = getAllDeletedEdgeIDs()
            var addBranchParams = false
            val params: MutableMap<String, String> = HashMap()
            params["id"] = jukeboxData.trackID!!
            if (!jukeboxData.addLastEdge)
                params["lb"] = "0"
            if (edges.isNotEmpty())
                params["d"] = edges.joinToString(",")
            if (jukeboxData.justBackwards)
                params["jb"] = "1"
            if (jukeboxData.justLongBranches)
                params["lg"] = "1"
            if (jukeboxData.removeSequentialBranches)
                params["sq"] = "0"
            if (jukeboxData.currentThreshold != jukeboxData.computedThreshold)
                params["thresh"] = jukeboxData.currentThreshold.toString()
            if (jukeboxData.audioUrl != null)
                params["audio"] = encodeURIComponent(jukeboxData.audioUrl!!)
            if (jukeboxData.minRandomBranchChance != defaultMinRandomBranchChance || jukeboxData.maxRandomBranchChance != defaultMaxRandomBranchChance || jukeboxData.randomBranchChanceDelta != defaultRandomBranchChanceDelta) {
                params["bp"] = buildString {
                    append(round(mapValueToPercent(jukeboxData.minRandomBranchChance, 0.0, 1.0)))
                    append(',')
                    append(round(mapValueToPercent(jukeboxData.maxRandomBranchChance, 0.0, 1.0)))
                    append(',')
                    append(
                        round(
                            mapValueToPercent(
                                jukeboxData.randomBranchChanceDelta,
                                minRandomBranchChanceDelta,
                                maxRandomBranchChanceDelta
                            )
                        )
                    )
                }
            }

            if (jukeboxData.disableKeys)
                params["nokeys"] = "1"

            val p = params.entries.joinToString(prefix = "?", separator = "&") { (k, v) -> "$k=$v" }

            window.history.replaceState(null, document.title, p)
        }
    }

    // we want to find the best, long backwards branch
// and ensure that it is included in the graph to
// avoid short branching songs like:
// http://labs.echonest.com/Uploader/index.html?trid=TRVHPII13AFF43D495
// sic. Paul Lamere
    fun longestBackwardBranch(type: String): Double {
        var longest = 0
        var quanta = track[type]
        for (i in quanta.indices) {
            var q = quanta[i]
            for (j in q.neighbours.indices) {
                var neighbour = q.neighbours[j]
                var which = neighbour.dest.which
                var delta = i - which
                if (delta > longest) {
                    longest = delta
                }
            }
        }

        return longest * 100.0 / (quanta.length.toDouble() as Double)
    }

    fun insertBestBackwardBranch(type: String, threshold: Int, maxThreshold: Int) {
        var found = false
        var branches: MutableList<Array<dynamic>> = ArrayList()
        var quanta = track[type]
        for (i in quanta.indices) {
            var q = quanta[i]
            for (j in q.allNeighbours.indices) {
                var neighbour = q.allNeighbours[j]

                if (neighbour.deleted) {
                    continue
                }

                var which = neighbour.dest.which
                var thresh = neighbour.distance
                var delta = i - which
                if (delta > 0 && thresh < maxThreshold) {
                    var percent = delta * 100.0 / (quanta.length.toDouble() as Double)
                    var edge = arrayOf(percent, i, which, q, neighbour)
                    branches.add(edge)
                }
            }
        }

        if (branches.isEmpty())
            return

        branches.sortBy { array -> array[0] as Double }
        branches.reverse()

        var best = branches[0]
        var bestQ = best[3]
        var bestNeighbour = best[4]
        var bestThreshold = bestNeighbour.distance
        if (bestThreshold > threshold) {
            bestQ.neighbours.add(bestNeighbour)
        }
    }

    fun calculateReachability(type: String) {
        var maxIter = 1000
//    var iter = 0
        var quanta = track[type]

        for (qi in quanta.indices) {
            var q = quanta[qi]
            q.reach = quanta.size - q.which
        }

        for (iter in 0 until maxIter) {
            var changeCount = 0
            for (qi in quanta.indices) {
                var q = quanta[qi]
                var changed = false

                for (i in q.neighbours.indices) {
                    var q2 = q.neighbours[i].dest
                    if (q2.reach > q.reach) {
                        q.reach = q2.reach
                        changed = true
                    }
                }

                if (qi < quanta.length - 1) {
                    var q2 = quanta[qi + 1]
                    if (q2.reach > q.reach) {
                        q.reach = q2.reach
                        changed = true
                    }
                }
                if (changed) {
                    changeCount++
                    for (j in 0 until q.which) {
                        var q2 = quanta[j]
                        if (q2.reach < q.reach)
                            q2.reach = q.reach
                    }
                }
            }

            if (changeCount == 0)
                break
        }
    }

    fun findBestLastBeat(type: String): Int {
        var reachThreshold = 50
        var quanta = track[type]
        var longest = 0
        var longestReach = 0
        for (i in quanta.indices.reversed()) {
            var q = quanta[i]
            //var reach = q.reach * 100 / quanta.length;
            var distanceToEnd = quanta.length - i

            // if q is the last quanta, then we can never go past it
            // which limits our reach
            // sic. Paul Lamere

            var reach = (q.reach - distanceToEnd) * 100.0 / (quanta.length.toDouble())

            if (reach > longestReach && q.neighbours.isNotEmpty()) {
                longestReach = reach
                longest = i
                if (reach >= reachThreshold)
                    break
            }
        }

        jukeboxData.totalBeats = quanta.length
        jukeboxData.longestReach = longestReach
        return longest
    }

    fun filterOutBadBranches(type: String, lastIndex: Int) {
        var quanta = track[type]
        for (i in 0 until lastIndex) {
            var q = quanta[i]
//        var newList: MutableList<dynamic> = ArrayList()
//        for (j in q.neighbours.indices) {
//            var neighbour = q.neighbours[j]
//            if (neighbour.dest.which < lastIndex)
//                newList.add(neighbour)
//        }
            q.neighbours = q.neighbours.filter { neighbour -> neighbour.dest.which < lastIndex }
        }
    }

    fun hasSequentialBranch(q: dynamic, neighbour: dynamic): Boolean {
        if (q.which == jukeboxData.lastBranchPoint)
            return false

        var qp = q.prev
        if (qp) {
            var distance = q.which - neighbour.dest.which
            for (i in qp.neighbours.indices) {
                var odistance = qp.which - qp.neighbours[i].dest.which
                if (distance == odistance)
                    return true
            }
        }

        return false
    }

    fun filterOutSequentialBranches(type: String) {
        var quanta = track[type]
        for (i in quanta.length - 1 until 1) {
            var q = quanta[i]
            q.neighbours = q.neighbours.filter { neighbour -> !hasSequentialBranch(q, neighbour) }
        }
    }

    fun calculateNearestNeighboursForQuantum(type: String, maxNeighbors: Int, maxThreshold: Int, q1: dynamic) {
        var edges: MutableList<JukeboxEdge> = ArrayList()
        var id = 0
        var quanta = track[type]
        for (i in quanta.indices) {
            if (i == q1.which)
                continue

            var q2 = quanta[i]
            var sum = 0.0
            for (j in q1.overlappingSegments.indices) {
                var seg1 = q1.overlappingSegments[j]
                var distance = 100.0
                if (j < q2.overlappingSegments.length) {
                    var seg2 = q2.overlappingSegments[j]
                    // some segments can overlap many quantums,
                    // we don't want this self segue, so give them a
                    // high distance
                    // sic. Paul Lamere
                    if (seg1.which == seg2.which) {
                        distance = 100.0
                    } else {
                        distance = getSegDistances(seg1, seg2)
                    }
                }

                sum += distance
            }

            var pdistance = if (q1.indexInParent == q2.indexInParent) 0 else 100
            var totalDistance = sum / (q1.overlappingSegments.length as Int) + pdistance
            if (totalDistance < maxThreshold) {
                val edge = JukeboxEdge(
                    id = id,
                    src = q1,
                    dest = q2,
                    distance = totalDistance,
                    curve = null,
                    deleted = false
                )
                edges.add(edge)
                id++
            }
        }

        edges.sortBy(JukeboxEdge::distance)

        q1.allNeighbours = emptyArray<dynamic>()
        for (i in 0 until min(maxNeighbors, edges.size)) {
            val edge = edges[i]
            q1.allNeighbours.add(edge)

            edge.id = jukeboxData.allEdges.size
            jukeboxData.allEdges.add(edge)
        }
    }

    fun precalculateNearestNeighbours(type: String, maxNeighbors: Int, maxThreshold: Int) {
        // skip if this is already done
        // sic. Paul Lamere

        if (track[type][0].allNeighbours != null)
            return

        jukeboxData.allEdges.clear()

        val quanta = track[type]
        for (qi in quanta.indices) {
            val q1 = quanta[qi]
            calculateNearestNeighboursForQuantum(type, maxNeighbors, maxThreshold, q1)
        }
    }

    fun collectNearestNeighbours(type: String, maxThreshold: Int): Int {
        var branchingCount = 0
        val quanta = track[type]
        for (qi in quanta.indices) {
            var q1 = quanta[qi]
            q1.neighbours = extractNearestNeighbours(q1, maxThreshold)
            if (q1.neighbours.isNotEmpty()) {
                branchingCount++
            }
        }

        return branchingCount
    }

    fun extractNearestNeighbours(q: dynamic, maxThreshold: Int): Array<JukeboxEdge> {
        val neighbours: MutableList<JukeboxEdge> = ArrayList()

        for (i in q.allNeighbours.indices) {
            val neighbour = q.allNeighbours[i] as JukeboxEdge

            if (neighbour.deleted)
                continue

            if (jukeboxData.justBackwards && neighbour.dest.which > q.which)
                continue

            if (jukeboxData.justLongBranches && abs((neighbour.dest.which - q.which).toDouble() as Double) < jukeboxData.minLongBranch)
                continue

            val distance = neighbour.distance
            if (distance <= maxThreshold)
                neighbours.add(neighbour)
        }

        return neighbours.toTypedArray()
    }

    fun segDistance(seg1: dynamic, seg2: dynamic, field: String, weighted: Boolean) =
        if (weighted) weightedEuclideanDistance(seg1[field], seg2[field]) else euclideanDistance(
            seg1[field],
            seg2[field]
        )

    /** ??? */
    fun calcBranchInfo(type: String) {
        val histogram: MutableMap<Double, Int> = HashMap()
        var total = 0
        val quanta = track[type]

        for (qi in quanta.indices) {
            var q = quanta[qi]

            for (i in q.neighbours.indices) {
                val neighbour = q.neighbours[i] as JukeboxEdge
                val distance = neighbour.distance
                val bucket = round(distance / 10.0)
                histogram[bucket] = (histogram[bucket] ?: 0) + 1
                total++
            }
        }

        console.log(histogram)
        console.log("total branches", total)
    }

    fun euclideanDistance(v1: IntArray, v2: IntArray): Double {
        var sum = 0.0

        for (i in v1.indices) {
            val delta = v2[i] - v1[i]
            sum += delta * delta
        }

        return sqrt(sum)
    }

    fun weightedEuclideanDistance(v1: IntArray, v2: IntArray): Double {
        var sum = 0.0

        for (i in v1.indices) {
            val delta = v1[i] - v1[i]
            //var weight = 1.0 / ( i + 1.0);
            val weight = 1.0
            sum += delta * delta * weight
        }

        return sqrt(sum)
    }

    fun redrawTiles() {
        jukeboxData.tiles.forEach { tile ->
            val newWidth = ((minTileWidth + tile.playCount * growthPerPlay) * curGrowFactor).coerceAtLeast(1)
            tile.rect.attr("width", newWidth)
        }
    }

    fun highlightCurves(tile: JukeboxTile, enable: Boolean, didJump: Boolean) {
        for (i in tile.q.neighbours.indices) {
            val curve = tile.q.neighbours[i].curve
            highlightCurve(curve, enable, didJump)
            if (driver.isRunning())
                break //just highlight the first one; sic. Paul Lamere
        }
    }

    fun getQuantumColour(q: dynamic): String {
        if (isSegment(q)) {
            return getSegmentColour(q)
        } else {
            val seg = getQuantumSegment(q)
            if (q != null)
                return getSegmentColour(q)
            else
                return "#000"
        }
    }

    fun getQuantumSegment(q: dynamic) = q.oseg
    fun isSegment(q: dynamic) = q.timbre != null

    fun getBranchColour(q: dynamic): String {
        if (q.neighbours.isEmpty()) {
            return toRGB(0.0, 0.0, 0.0)
        } else {
            val red = (q.neighbours.length.toDouble() as Double) / jukeboxData.maxBranches
            return toRGB(red, 0.0, 1.0 - red)
        }
    }

    fun createNewTile(which: Int, q: dynamic, height: Double, width: Double): JukeboxTile {
//    var padding = 0
        val tile =
            JukeboxTile(this, which, width, height, getBranchColour(q), getQuantumColour(q), getQuantumColour(q), q)
        q.tile = tile
        tile.normal()
        return tile
    }

    fun createTilePanel(qtype: String) {
        removeAllTiles()
        jukeboxData.tiles.clear()
        jukeboxData.tiles.addAll(createTiles(qtype))
    }

    val cmin = DoubleArray(3) { 100.0 }
    val cmax = DoubleArray(3) { -100.0 }

    fun normaliseColour() {
        for (j in cmin.indices) cmin[j] = 100.0
        for (j in cmax.indices) cmax[j] = -100.0

        val qlist = track.segments
        for (i in qlist.indices) {
            for (j in cmin.indices) {
                val t = qlist[i].timbre[j + 1] as Double

                if (t < cmin[j])
                    cmin[j] = t
                if (t > cmax[j])
                    cmax[j] = t
            }
        }
    }

    fun getSegmentColour(seg: dynamic): String {
        val results = DoubleArray(cmin.size) { i -> ((seg.timbre[i + 1] as Double) - cmin[i]) / (cmax[i] - cmin[i]) }
        return toRGB(results[1], results[2], results[0])
    }

    fun Double.toHexComponent() = roundToInt().toString(16).padStart(2, '0')

    fun toRGB(red: Double, green: Double, blue: Double) =
        "#${(red * 255).toHexComponent()}${(green * 255).toHexComponent()}${(blue * 255).toHexComponent()}"

    fun removeAllTiles() {
        for (i in jukeboxData.tiles.indices) {
            jukeboxData.tiles[i].rect?.remove()
        }

        jukeboxData.tiles.clear()
    }

    fun deleteEdge(edge: JukeboxEdge) {
        if (!edge.deleted) {
            jukeboxData.deletedEdgeCount++
            edge.deleted = true
            if (edge.curve) {
                edge.curve.remove()
                edge.curve = null
            }

            for (j in edge.src.neighbours.indices) {
                val otherEdge = edge.src.neighbours[j]
                if (edge == otherEdge) {
                    edge.src.neighbours.splice(j, 1)
                    break
                }
            }
        }
    }

    fun keydown(event: JQueryKeyEventObject) {
        if (!jQuery("#hero").`is`(":visible") || jQuery("#controls").`is`(":visible") || jukeboxData.disableKeys)
            return

        when (event.key) {
            JukeboxKeys.ARROW_RIGHT -> driver.incr++
            JukeboxKeys.ARROW_LEFT -> driver.incr--
            JukeboxKeys.ARROW_UP -> driver.incr = 1
            JukeboxKeys.ARROW_DOWN -> driver.incr = 0

            JukeboxKeys.CONTROL -> controlled = true
            JukeboxKeys.SHIFT -> shifted = true

            JukeboxKeys.H -> {
                if (jukeboxData.infiniteMode) {
                    jukeboxData.infiniteMode = false
                    showInfo("Bringing it on home")
                } else {
                    jukeboxData.infiniteMode = true
                    showInfo("Infinite Mode enabled")
                }
            }
            JukeboxKeys.SPACE -> {
                if (driver.isRunning()) {
                    driver.stop()
                } else {
                    driver.start()
                }
            }
            in JukeboxKeys.BACKSPACE_OR_DELETE -> {
                if (jukeboxData.selectedCurve) {
                    deleteEdge(jukeboxData.selectedCurve.edge)
                    jukeboxData.selectedCurve = null
                    drawVisualisation()
                }
            }

            else -> return
        }

        event.preventDefault()
    }

    fun keyup(event: JQueryKeyEventObject) {
        when (event.key) {
            JukeboxKeys.CONTROL -> controlled = false
            JukeboxKeys.SHIFT -> shifted = false
            else -> return
        }

        event.preventDefault()
    }

    fun searchForTrack() {
        console.log("Search for a track")
        val q = jQuery("#search-text").`val`().toString()
        console.log(q)

        if (q.isNotBlank()) {
            ajax {
                this.url = "search"
                this.data = json("q" to q, "results" to 30)
                this.dataType = "json"
                this.method = "GET"
            }.done { data, _, _ ->
                console.log(data)
                listTracks("#search-list", data as Array<dynamic>)
            }
        }
    }

    fun getShareUrl(callback: (id: String) -> Unit) {
        val q = document.URL.split('?')[1]
        ajax {
            url = "/api/site/shrink"
            dataType = "json"
            type = "POST"
            data = "service=jukebox&$q"
        }.done { data, _, _ ->
            callback((data as Json)["id"] as String)
        }
    }

    fun checkIfStarred() {
        getShareUrl { id ->
            ajax {
                url = "/api/profile/me"
                dataType = "json"
                type = "GET"
            }.done { data, _, _ ->
                val stars = (data as Json)["stars"] as Array<String>
                if (id in stars)
                    jQuery("#star").text("Unstar")
            }
        }
    }

    @ExperimentalContracts
    fun init() {
        jQuery(document).keydown(this::keydown)
        jQuery(document).keyup(this::keyup)

        paper = Raphael("tiles", width, height)

        jQuery("#error").hide()

        jQuery("#go").click {
            if (driver.isRunning()) {
                driver.stop(); Unit
            } else {
                driver.start(); Unit
            }
        }

        jQuery("#tune").click {
            val controls = jQuery("#controls")
            if (jukeboxData.tuningOpen) {
                controls.dialog("close")
                jukeboxData.tuningOpen = false
            } else {
                controls.dialog("open")
                jukeboxData.tuningOpen = true
            }
        }

        jQuery("#star").click {
            getShareUrl { id ->
                val starred = jQuery("#star").text() == "Star"
                ajax {
                    url = "/api/profile/stars/$id"
                    type = if (starred) "DELETE" else "PUT"
                    headers = json(
//                        "X-XSRF-TOKEN" to document.cookie.substring(document.cookie.indexOf("XSRF-TOKEN")).split(";")[0].split(
//                            "="
//                        ).slice(1).join("=")
                        "X-XSRF-TOKEN" to document.cookie.substring(document.cookie.indexOf("XSRF-TOKEN")).split(";")[0].substringAfter(
                            '='
                        )
                    )
                }.done { data, _, _ ->
                    if (starred) {
                        jQuery("#info").text("Successfully unstarred!")
                        jQuery("#star").text("Star")
                    } else {
                        jQuery("#info").text("Successfully starred!")
                        jQuery("#star").text("Unstar")
                    }
                }
            }
        }

        jQuery("#short-url").click {
            getShareUrl { id ->
                window.prompt(
                    "Copy the URL below and press 'Enter' to automatically close this prompt",
                    "${window.location.origin}/api/site/expand/$id/redirect"
                )
            }
        }

        jQuery("#og-audio-source").click {
            //TODO: Delete this! Make it a regular href!
            window.location.href = jukeboxData.ogAudioUrl!!; Unit
        }

        jQuery("#canonize").click {
            //TODO: Delete this! Make it a regular href!
            window.location.href = document.URL.replace("jukebox_go", "canonizer_go"); Unit
        }

        jQuery("#controls").attr("visibility", "visible")
        jQuery("#controls").dialog {
            autoOpen = false
            title = "Fine tune your endless song"
            width = 350
            position = arrayOf(4, 4)
            resizable = false
        }

        jQuery("#reset-edges").click { resetTuning() }

        jQuery("#close-tune").click {
            val controls = jQuery("#controls")
            controls.asDynamic().dialog("close")
            jukeboxData.tuningOpen = false
            Unit
        }

        jQuery("#last-branch").change {
            jukeboxData.addLastEdge = jQuery("#last-branch").`is`(":checked")
            drawVisualisation()
        }

        jQuery("#reverse-branch").change {
            jukeboxData.justBackwards = jQuery("#reverse-branch").`is`(":checked")
            drawVisualisation()
        }

        jQuery("#long-branch").change {
            jukeboxData.justLongBranches = jQuery("#long-branch").`is`(":checked")
            drawVisualisation()
        }

        jQuery("#sequential-branch").change {
            jukeboxData.removeSequentialBranches = jQuery("#sequential-branch").`is`(":checked")
            drawVisualisation()
        }

        jQuery("#threshold-slider").slider {
            max = 80
            min = 2
            step = 1
            value = 30
            changeFunc = { _, ui ->
                if (ui.value != null) {
                    freeze(ui.value) { value ->
                        if (value != null) {
                            jukeboxData.currentThreshold = value.toInt()
                            drawVisualisation()
                        }
                    }
                }
            }
            slideFunc = { _, ui ->
                freeze(ui.value) { value ->
                    if (value != null) {
                        jukeboxData.currentThreshold = value.toInt()
                    }
                }
            }
        }

        jQuery("#probability-slider").slider {
            max = 100
            min = 0
            range = true
            step = 1
            values = arrayOf(
                round(defaultMinRandomBranchChance * 100),
                round(defaultMaxRandomBranchChance * 100)
            )

            changeFunc = { _, ui ->
                freeze(ui.values) { values ->
                    if (values != null) {
                        jukeboxData.minRandomBranchChance = values[0].toDouble() / 100.0
                        jukeboxData.maxRandomBranchChance = values[1].toDouble() / 100.0
                        setTunedUrl()
                    }
                }
            }

            slideFunc = { _, ui ->
                freeze(ui.values) { values ->
                    if (values != null) {
                        jukeboxData.minRandomBranchChance = values[0].toDouble() / 100.0
                        jukeboxData.maxRandomBranchChance = values[1].toDouble() / 100.0
                    }
                }
            }
        }

        jQuery("#probability-ramp-slider").slider {
            max = 100
            min = 0
            step = 2
            value = 30
            changeFunc = { _, ui ->
                freeze(ui.value) { value ->
                    if (value != null) {
                        jukeboxData.randomBranchChanceDelta =
                            mapPercentToRange(value.toDouble(), minRandomBranchChanceDelta, maxRandomBranchChanceDelta)
                        setTunedUrl()
                    }
                }
            }
            slideFunc = { _, ui ->
                freeze(ui.value) { value ->
                    if (value != null) {
                        jukeboxData.randomBranchChanceDelta =
                            mapPercentToRange(value.toDouble(), minRandomBranchChanceDelta, maxRandomBranchChanceDelta)
                    }
                }
            }
        }

        jQuery("#audio-url")
            .keypress { eventObject: JQueryKeyEventObject ->
            if (eventObject.key == JukeboxKeys.ENTER) {
                jukeboxData.audioUrl = jQuery(eventObject.target).`val`() as String
                setTunedUrl()
                window.location.reload()
            }
        }

        jQuery("#audio-upload").change {
            ajax {
                url = "/api/audio/upload"
                type = "POST"
                val uploadForm = jQuery("#audio-upload-form")
                val formElement = uploadForm.get()[0] as HTMLFormElement
                data = FormData(formElement)
                processData = false
                contentType = false
                headers = json(
                    "X-XSRF-TOKEN" to document.cookie.substring(document.cookie.indexOf("XSRF-TOKEN")).split(";")[0].substringAfter(
                        '='
                    )
                )
                xhr = lambda@{
                    val xhr = XMLHttpRequest()
                    xhr.upload.addEventListener("progress", { event ->
                        if ((event as ProgressEvent).lengthComputable) {
                            val percentComplete = (event.loaded.toDouble() / event.total.toDouble()) * 100.0
                            val audioProgress = jQuery("#audio-progress")
                            audioProgress.text("${percentComplete.toFixed(2)}%")
                            audioProgress.css("width", "$percentComplete%")
                        }
                    }, false)

                    return@lambda xhr
                }
            }.then<dynamic>(doneCallback = { data: Any, _: String, _: JQueryXHR ->
                jukeboxData.audioUrl = "upl:${(data as Json)["id"]}"
                setTunedUrl()
                window.location.reload()
            }, failCallback = { _: JQueryXHR, _: String, errorThrown: Any ->
                println("Error upon attempting to upload: $errorThrown")
            })
        }

        jQuery("#disable-keys").change {
            jukeboxData.disableKeys = jQuery("#disable-keys").`is`(":checked")
            setTunedUrl()
        }

        jQuery("#volume-slider").slider {
            min = 0
            max = 100
            value = 50
            range = "min"
            slideFunc = { _, ui ->
                freeze(ui.value) { value ->
                    if (value != null) {
                        jQuery("#volume").text(value.toString())
                        player.audioGain.gain.value = value.toDouble() / 100.0
                    }
                }
            }
        }

        val context = getAudioContext()
        if (context == null) {
            showError("Sorry, this app needs advanced web audio. Your browser doesn't support it. Try the latest version of Chrome, Firefox, or Safari.")
            hideAll()
        } else {
//            remixer = createJRemixer(context)
//            player = remixer.getPlayer()
            processParams()
            checkIfStarred()
        }
    }

    fun processParams() {
        val params: MutableMap<String, String> = HashMap()
        val q = document.URL.split('?')[1].split('&')
        for (i in q.indices) {
            val pv = q[i].split('=')
            val p = pv[0]
            val v = pv[1]
            params[p] = v
        }

        if ("id" in params) {
            val id = params.getValue("id")
            jukeboxData.trackID = id

            val thresh = 0
            if ("thresh" in params) {
                jukeboxData.currentThreshold = params.getValue("thresh").toInt()
            }

            if ("audio" in params) {
                jukeboxData.audioUrl = decodeURIComponent(params.getValue("audio"))
            }

            if ("d" in params) {
                val df = params.getValue("d").split(',')
                for (i in df.indices) {
                    val di = df[i].toInt()
                    jukeboxData.deletedEdges.add(di)
                }
            }

            if ("lb" in params) {
                jukeboxData.addLastEdge = params["lb"] == "0"
            }

            if ("jb" in params) {
                jukeboxData.justBackwards = params["jb"] == "1"
            }

            if ("sq" in params) {
                jukeboxData.removeSequentialBranches = params["sq"] == "0"
            }

            if ("nokeys" in params) {
                jukeboxData.disableKeys = params["nokeys"] == "1"
            }

            if ("bp" in params) {
                val bp = params.getValue("bp")
                val fields = bp.split(',')
                if (fields.size == 3) {
                    val minRange = fields[0].toInt()
                    val maxRange = fields[1].toInt()
                    val delta = fields[2].toInt()

                    jukeboxData.minRandomBranchChance = mapPercentToRange(minRange.toDouble(), 0.0, 1.0)
                    jukeboxData.maxRandomBranchChance = mapPercentToRange(maxRange.toDouble(), 0.0, 1.0)
                    jukeboxData.randomBranchChanceDelta =
                        mapPercentToRange(delta.toDouble(), minRandomBranchChanceDelta, maxRandomBranchChanceDelta)
                }
            }

            setDisplayMode(true)
            fetchAnalysis(id)
        } else {
            //Analysis is here
            setDisplayMode(false)
        }
    }
}

fun showPlotPage(id: String) {
    window.location.href = "${window.location.protocol}//${window.location.host}${window.location.pathname}?id=$id"
}

fun isTuned(url: String) = url.indexOf('&') > 0

fun mapPercentToRange(percent: Double, min: Double, max: Double): Double =
    (max - min) * percent.coerceIn(0.0, 100.0) / 100.0 + min

fun mapValueToPercent(value: Double, min: Double, max: Double) =
    100.0 * (value.coerceIn(min, max) - min) / (max - min)

fun secondsToTime(secs: Double): String {
    var time = floor(secs)
    val hours = floor(time / 3600)
    time -= hours * 3600
    val mins = floor(secs / 60)
    time -= mins * 60

    return buildString {
        append(hours.toString().padStart(2, '0'))
        append(':')
        append(mins.toString().padStart(2, '0'))
        append(':')
        append(secs.toString().padStart(2, '0'))
    }
}