data class JukeboxEdge(
    var id: Int,
    val src: dynamic,
    val dest: dynamic,
    val distance: Double,
    var curve: dynamic,
    var deleted: Boolean
)