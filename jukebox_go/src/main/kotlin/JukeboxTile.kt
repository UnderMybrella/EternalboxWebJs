import jquery.jQuery
import org.w3c.dom.events.MouseEvent
import kotlin.math.PI
import kotlin.math.floor
import kotlin.math.round

class JukeboxTile(val jukebox: Jukebox, val which: Int, val width: Double, val height: Double, val branchColour: String, val quantumColour: String, val normalColour: String, val q: dynamic) {
    var rect: dynamic = jukebox.paper.rect(0, 0, width, height)
    var label: dynamic = null
    var isPlaying = false
    var isScaled = false
    var playCount = 0

    fun move(x: Double, y: Double) {
        rect?.attr("x", x)
        rect?.attr("y", y)
        label?.attr("x", x + 2)
        label?.attr("y", y + 8)
    }

    fun rotate(angle: Double) {
        val dAngle = 360.0 * (angle / (PI * 2))
        rect?.transform("r$dAngle")
    }

    fun play(force: Boolean) {
        if (force || jukebox.shifted) {
            playStyle(true)
            jukebox.player.play(0, q)
        } else if (jukebox.controlled) {
            queueStyle()
            jukebox.player.queue(q)
        } else {
            selectStyle()
        }

        if (force) {
            jukebox.showInfo("Selected tile ${q.which}")
            jukebox.jukeboxData.selectedTile = this
        }
    }

    fun selectStyle() {
        rect?.attr("fill", "#C9A")
    }

    fun queueStyle() {
        rect?.attr("fill", "#AFF")
    }

    fun pauseStyle() {
        rect?.attr("fill", "#F8F")
    }

    fun playStyle(didJump: Boolean) {
        if (isPlaying) {
            isPlaying = true
            if (!isScaled) {
                isScaled = true
                rect?.attr("width", jukebox.maxTileWidth)
            }

            rect?.toFront()
            rect?.attr("fill", jukebox.highlightColour)
            jukebox.highlightCurves(this, true, didJump)
        }
    }

    fun normal() {
        rect?.attr("fill", normalColour)
        if (isScaled) {
            isScaled = false
            //this.rect.scale(1/1.5, 1/1.5);
            val newWidth = round(((jukebox.minTileWidth + playCount * jukebox.growthPerPlay) * jukebox.curGrowFactor).toDouble()).coerceAtLeast(1.0)
            if (newWidth > 90) {
                jukebox.curGrowFactor /= 2
                jukebox.redrawTiles()
            } else {
                rect?.attr("width", newWidth)
            }
        }

        jukebox.highlightCurves(this, false, false)
        isPlaying = false
    }

    init {
        rect?.attr("stroke", normalColour)
        rect?.attr("stroke-width", 0)

        rect?.mouseover = { event: MouseEvent ->
            playStyle(false)
            if (jukebox.debugMode) {
                if (q.which > jukebox.jukeboxData.lastBranchPoint) {
                    jQuery("#beats").text("${q.which} ${q.reach}*")
                } else {
                    val qLength = jukebox.track.beats.length
                    val distanceToEnd = qLength - q.which
                    jQuery("#beats").text("${q.which} ${q.reach} ${floor(q.reach - distanceToEnd) * 100.0 / (qLength.toDouble() as Double)}")
                }
            }

            event.preventDefault()
        }

        rect?.mouseout = { event: MouseEvent ->
            normal()
            event.preventDefault()
        }

        rect?.mousedown = { event: MouseEvent ->
            event.preventDefault()
            jukebox.driver.nextTile = this

            if (!jukebox.driver.isRunning())
                jukebox.driver.start()

            if (jukebox.controlled) {
                jukebox.driver.incr = 0
            }
        }
    }
}