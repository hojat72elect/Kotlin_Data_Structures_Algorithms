package extensions

fun String.isAnagramOf(other: String) = this.groupBy { it } == other.groupBy { it }