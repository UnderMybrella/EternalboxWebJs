import jquery.jQuery
import kotlin.browser.document
import kotlin.browser.window
import kotlin.js.Date.Companion.now
import kotlin.random.Random

class JukeboxDriver(val jukebox: Jukebox) {
    val player get() = jukebox.player
    val jukeboxData get() = jukebox.jukeboxData

    var curTile: JukeboxTile? = null
    var curOp: (() -> JukeboxTile?)? = null
    var incr = 1
    var nextTile: JukeboxTile? = null
    var bounceSeed: JukeboxTile? = null
    var bounceCount = 0
    var nextTime = 0
    var lateCounter = 0
    var lateLimit = 4

    var startTime = 0.0

    var beatDiv = jQuery("#beats")
    var timeDiv = jQuery("#time")

    fun next(): JukeboxTile? {
        if (curTile == null) {
            return jukeboxData.tiles[0]
        } else {
            val nextIndex: Int
            if (jukebox.shifted) {
                if (bounceSeed == null) {
                    bounceSeed = curTile
                    bounceCount = 0
                }

                if (bounceCount++ % 2 == 1) {
                    return selectNextNeighbour(bounceSeed!!)
                } else {
                    return bounceSeed
                }
            }

            if (jukebox.controlled) {
                return curTile!!
            } else {
                if (bounceSeed != null) {
                    val nextTile = bounceSeed
                    bounceSeed = null
                    return nextTile
                } else {
                    nextIndex = curTile!!.which + incr
                }
            }

            if (nextIndex < 0) {
                return jukeboxData.tiles[0]
            } else if (nextIndex >= jukeboxData.tiles.size) {
                curOp = null
                player.stop()
                return null
            } else {
                return selectRandomNextTile(jukeboxData.tiles[nextIndex])
            }
        }
    }

    fun selectRandomNextTile(seed: JukeboxTile): JukeboxTile {
        if (seed.q.neighbours.isEmpty()) {
            return seed
        } else if (shouldRandomBranch(seed.q)) {
            val next = seed.q.neighbours.remove(0)
            jukeboxData.lastThreshold = next.distance
            seed.q.neighbours.add(next)
            val tile = next.dest.tile
            return tile as JukeboxTile
        } else {
            return seed
        }
    }

    fun selectRandomNextTileNew(seed: JukeboxTile): JukeboxTile {
        if (seed.q.neighbours.isEmpty()) {
            return seed
        } else if (shouldRandomBranch(seed.q)) {
            val start = window.performance.now()
            val (tile, score) = findLeastPlayedNeighbour(seed, 5)
            val delta = window.performance.now() - start
            console.log("lhd ", seed.which, tile.which, score, delta)
            return tile
        } else {
            return seed
        }
    }

    /**
     * we look for the path to the tile that will bring
     * us to the least played tile in the future (we look
     * at lookAhead beats into the future
     *
     * sic. Paul Lamere
     */
    fun findLeastPlayedNeighbour(seed: JukeboxTile, lookAhead: Int): Pair<JukeboxTile, Int> {
        val nextTiles: MutableList<JukeboxTile> = ArrayList()

        if (seed.q.which != jukeboxData.lastBranchPoint) {
            nextTiles.add(seed)
        }
        seed.q.neighbours.forEach { edge -> nextTiles.add(edge.dest.tile as JukeboxTile) }

        nextTiles.shuffle()

        if (lookAhead == 0) {
            val minTile = nextTiles.minBy(JukeboxTile::playCount)!!
            return Pair(minTile, minTile.playCount)
        } else {
            var minTile: Pair<JukeboxTile, Int>? = null
            nextTiles.forEach { tile ->
                val futureTile = findLeastPlayedNeighbour(tile, lookAhead - 1)
                if (minTile == null || futureTile.second < minTile!!.second)
                    minTile = futureTile
            }

            return minTile!!
        }
    }

    fun selectNextNeighbour(seed: JukeboxTile): JukeboxTile {
        if (seed.q.neighbours.isEmpty()) {
            return seed
        } else {
            return seed.q.neighbours.shift().dest.tile as JukeboxTile
        }
    }

    fun shouldRandomBranch(q: dynamic): Boolean {
        if (jukeboxData.infiniteMode) {
            if (q.which == jukeboxData.lastBranchPoint) {
                return true
            }

            // return true; // TEST, remove; sic. Paul Lamere

            jukeboxData.curRandomBranchChance += jukeboxData.randomBranchChanceDelta
            if (jukeboxData.curRandomBranchChance > jukeboxData.maxRandomBranchChance)
                jukeboxData.curRandomBranchChance = jukeboxData.maxRandomBranchChance

            val shouldBranch = Random.nextDouble() < jukeboxData.curRandomBranchChance
            if (shouldBranch)
                jukeboxData.curRandomBranchChance = jukeboxData.minRandomBranchChance
            return shouldBranch
        } else {
            return false
        }
    }

    fun updateStats() {
        beatDiv.text(jukeboxData.beatsPlayed)
        timeDiv.text(secondsToTime(now() - startTime / 1000.0))
    }

    fun process() {
        curTile?.normal()

        if (curOp != null) {
            val lastTile = curTile
            if (nextTile != null) {
                curTile = nextTile
                nextTile = null
            } else {
                curTile = curOp!!()
            }

            if (curTile != null) {
                val ctime = player.curTime() as Int
                // if we are consistently late we should shutdown; sic. Paul Lamere
                if (ctime > nextTime) {
                    if (lateCounter++ > lateLimit && document.isHidden) {
                        jukebox.showInfo("Sorry, can't play music properly in the background")
                        stop()
                        return
                    }
                } else {
                    lateCounter = 0
                }

                nextTime = player.play(nextTime, curTile!!.q)

                if (jukebox.fastMode) {
                    nextTime = 0 // set to zero for speedup sim mode; sic. Paul Lamere
                }

                curTile!!.playCount++

                val delta = nextTime - ctime
                window.setTimeout({
                    process()
                }, 1000 * delta - 10)

                val didJump = lastTile != null && lastTile.which != curTile!!.which - 1
                curTile!!.playStyle(true)
                jukeboxData.beatsPlayed++
                updateStats()
            }
        } else {
            curTile?.normal()
        }
    }

    fun resetPlayCounts() {
        jukeboxData.tiles.forEach { tile -> tile.playCount = 0 }
        jukebox.curGrowFactor = 1
        jukebox.redrawTiles()
    }

    fun start() {
        jukeboxData.beatsPlayed = 0
        nextTime = 0
        bounceSeed = null
        jukeboxData.infiniteMode = true
        jukeboxData.curRandomBranchChance = jukeboxData.minRandomBranchChance
        lateCounter = 0
        curOp = this::next
        startTime = now()
        jQuery("#go").text("Stop")
        jukebox.showError("")
        jukebox.showInfo("")
        resetPlayCounts()
        process()
    }

    fun stop() {
        val delta = now() - startTime
        jQuery("#go").text("Play")
        curTile?.normal()
        curTile = null
        curOp = null
        bounceSeed = null
        incr = 1
        player.stop()
    }

    fun isRunning() = curOp != null
}