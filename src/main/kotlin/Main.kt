import sort.heapify

fun main() {
    val myList = arrayListOf(52, 23, 1, 6)
    for (i in 1 downTo 0) {
        heapify(myList, 4, i)
    }
}