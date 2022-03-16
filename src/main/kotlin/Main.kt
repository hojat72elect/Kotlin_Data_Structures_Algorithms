import sort.heapSort

fun main() {
    val myList = arrayListOf(52, 23, 1, 6)
    println("The original list: $myList")
    heapSort(myList)
    println("The sorted list: $myList")
}