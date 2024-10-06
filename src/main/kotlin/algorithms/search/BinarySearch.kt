package algorithms.search

/**
 * @author Hojat Ghasemi,
 * 2022-03-08
 * https://github.com/hojat72elect
 *
 * An extension function for ArrayList. You just give it a sorted
 * list and the value you wanna search for. If the value exists in
 * the list, the index of its first appearance will be returned;
 * otherwise, -1.
 */

fun <T : Comparable<T>> ArrayList<T>._binarySearch(
    value: T,
    range: IntRange = indices
): Int? {
    if (range.first > range.last) {
        // The specific part of the ArrayList that we're checking
        // in this iteration of the algorithm isn't incrementally
        // sorted so  just return null.
        return null
    } else {
        val size = range.last - range.first + 1 // the size of the
        // chunk of ArrayList which will be checked in this iteration
        val middleIndex = range.first + size / 2
        return when {
            this[middleIndex] == value -> {
                middleIndex
            }
            this[middleIndex] > value -> {
                // the desired value is less than middleIndex
                this._binarySearch(value, range.first until middleIndex)
            }
            else -> {
                // the desired value is more than middleIndex
                this._binarySearch(value, (middleIndex + 1)..range.last)
            }
        }
    }
}