import jquery.jQuery
import kotlin.math.round
import kotlin.properties.Delegates

class JukeboxData(
    val jukebox: Jukebox,

    var infiniteMode: Boolean,
    var maxBranches: Int,
    var maxBranchThreshold: Int,

    var computedThreshold: Int,
    currentThreshold: Int,
    addLastEdge: Boolean,
    justBackwards: Boolean,
    justLongBranches: Boolean,
    removeSequentialBranches: Boolean,

    deletedEdgeCount: Int,

    var lastBranchPoint: Int,
    longestReach: Int,

    var beatsPlayed: Int,
    totalBeats: Int,
    branchCount: Int,

    var selectedTile: JukeboxTile?,
    var selectedCurve: dynamic,

    var tiles: MutableList<JukeboxTile>,
    val allEdges: MutableList<JukeboxEdge>,
    val deletedEdges: MutableList<Int>,

    audioUrl: String?,
    var trackID: String?,
    var ogAudioUrl: String?,

    minRandomBranchChance: Double,
    maxRandomBranchChance: Double,
    randomBranchChanceDelta:Double,
    curRandomBranchChance: Double,
    lastThreshold: Int,

    var tuningOpen: Boolean,
    disableKeys: Boolean,

    var minLongBranch: Int
) {
    var currentThreshold: Int by Delegates.observable(currentThreshold) { _, _, newValue ->
        jQuery("#threshold").text(newValue.toString())
        jQuery("#threshold-slider").slider("value", newValue)
    }
    var addLastEdge: Boolean by Delegates.observable(addLastEdge) { _, _, newValue ->
        jQuery("#last-branch").attr("checked", newValue.toString())
        jukebox.setTunedUrl()
    }
    var justBackwards: Boolean by Delegates.observable(justBackwards) { _, _, newValue ->
        jQuery("#reverse-branch").attr("checked", newValue.toString())
        jukebox.setTunedUrl()
    }
    var justLongBranches: Boolean by Delegates.observable(justLongBranches) { _, _, newValue ->
        jQuery("#long-branch").attr("checked", newValue.toString())
        jukebox.setTunedUrl()
    }
    var removeSequentialBranches: Boolean by Delegates.observable(removeSequentialBranches) { _, _, newValue ->
        jQuery("#sequential-branch").attr("checked", newValue.toString())
        jukebox.setTunedUrl()
    }

    var deletedEdgeCount: Int by Delegates.observable(deletedEdgeCount) { _, _, newValue -> jQuery(
        "#deleted-branches"
    ).text(newValue.toString()) }

    var longestReach: Int by Delegates.observable(longestReach) { _, _, newValue ->
        jQuery("#loop-length-percent").text(newValue.toString())
        val loopBeats = round(newValue.toDouble() * this.totalBeats.toDouble() / 100.0)
        jQuery("#loop-length-beats").text(round(loopBeats).toString())
        jQuery("#total-beats").text(this.totalBeats.toString())
    }

    var totalBeats: Int by Delegates.observable(totalBeats) { _, _, newValue -> jQuery("#total-beats")
        .text(newValue.toString()) }
    var branchCount: Int by Delegates.observable(branchCount) { _, _, newValue -> jQuery("#branch-count")
        .text(newValue.toString()) }

    var audioUrl: String? by Delegates.observable(audioUrl) { _, _, newValue ->
        if (newValue != null) {
            jQuery("#audio-url").`val`(decodeURIComponent(newValue))
        } else {
            jQuery("#audio-url").`val`("")
        }
    }

    var minRandomBranchChance: Double by Delegates.observable(minRandomBranchChance) { _, _, newValue ->
        jQuery("#min-prob").text(round(newValue * 100))
        jQuery("#probability-slider").slider("values", arrayOf<Number>(newValue * 100, this.maxRandomBranchChance * 100))
        this.curRandomBranchChance = curRandomBranchChance.coerceIn(newValue, this.maxRandomBranchChance)
    }
    var maxRandomBranchChance: Double by Delegates.observable(maxRandomBranchChance) { _, _, newValue ->
        jQuery("#max-prob").text(round(newValue * 100))
        jQuery("#probability-slider")
            .slider("values", arrayOf<Number>(this.minRandomBranchChance * 100, newValue * 100))
        this.curRandomBranchChance = curRandomBranchChance.coerceIn(this.minRandomBranchChance, newValue)
    }
    var randomBranchChanceDelta: Double by Delegates.observable(randomBranchChanceDelta) { _, _, newValue ->
        val value = round(mapValueToPercent(this.randomBranchChanceDelta, jukebox.minRandomBranchChanceDelta, jukebox.maxRandomBranchChanceDelta))
        jQuery("#ramp-speed").text(value)
        jQuery("#probability-ramp-slider").slider("value", value)
    }
    var curRandomBranchChance: Double by Delegates.observable(curRandomBranchChance) { _, _, newValue ->
        jQuery("#branch-chance").text(round(newValue * 100))
    }
    var lastThreshold: Int by Delegates.observable(lastThreshold) { _, _, newValue ->
        jQuery("#last-threshold").text(newValue)
    }

    var disableKeys: Boolean by Delegates.observable(disableKeys) { _, _, newValue ->
        jQuery("#disable-keys").attr("checked", newValue.toString())
        jukebox.setTunedUrl()
    }
}