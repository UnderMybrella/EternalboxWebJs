import org.w3c.dom.Document
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@ExperimentalContracts
public inline fun <T, R> freeze(receiver: T, block: (T) -> R): R? {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }

    return block(receiver)
}

@Suppress("NOTHING_TO_INLINE")
inline fun Double.toFixed(digits: Int): String = asDynamic().toFixed(digits) as String
external fun encodeURIComponent(uri: String): String
external fun decodeURIComponent(uri: String): String

const val isHiddenJs: String = """if (typeof document.hidden !== "undefined") { document.hidden; } else if (typeof document.msHidden !== "undefined") { document.msHidden; } else if (typeof document.webkitHidden !== "undefined") { document.webkitHidden; } else { true; }"""
val Document.isHidden: Boolean
    get() = js(isHiddenJs) as Boolean