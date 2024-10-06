package extensions

/**
 * Checks if the current string is an anagram of the given string.
 *
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * @param other the string to check against.
 * @return true if the current string is an anagram of the given string, false otherwise
 */
fun String.isAnagramOf(other: String) = this.groupBy { it } == other.groupBy { it }

/**
 * Checks if the given word or string is PANGRAM (If it contains every letter of the English alphabet at least once).
 *
 * For example, "The quick brown fox jumps over the lazy dog" is a well-known pangram.
 */
fun String.isPangram(): Boolean {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    return alphabet.all { contains(it, ignoreCase = true) }
}