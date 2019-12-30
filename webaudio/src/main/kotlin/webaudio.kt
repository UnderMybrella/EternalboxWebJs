fun AudioContext(): dynamic = js("new AudioContext()")
fun WebkitAudioContext(): dynamic = js("new webkitAudioContext()")

fun getAudioContext(): dynamic {
    if (js("typeof AudioContext") != null)
        return AudioContext()
    else if (js("typeof webkitAudioContext") != null)
        return WebkitAudioContext()
    else
        return null
}