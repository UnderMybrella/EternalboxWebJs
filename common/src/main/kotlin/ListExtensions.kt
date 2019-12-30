public inline fun <T, reified R> Array<T>.mapArray(transform: (T) -> R): Array<R> =
    Array(size) { index -> transform(this[index]) }

/**
 * Returns an array of Int containing all of the elements of this collection.
 */
public inline fun Array<Number>.toIntArray(): IntArray {
    val result = IntArray(size)
    var index = 0
    for (element in this)
        result[index++] = element.toInt()
    return result
}

/**
 * Returns an array of Int containing all of the elements of this collection.
 */
public inline fun Array<Number>.toDoubleArray(): DoubleArray {
    val result = DoubleArray(size)
    var index = 0
    for (element in this)
        result[index++] = element.toDouble()
    return result
}

/**
 * Returns an array of Int containing all of the elements of this collection.
 */
public inline fun <T> Collection<T>.toIntArray(transform: (T) -> Int): IntArray {
    val result = IntArray(size)
    var index = 0
    for (element in this)
        result[index++] = transform(element)
    return result
}