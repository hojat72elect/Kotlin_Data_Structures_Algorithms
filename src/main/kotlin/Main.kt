import sort.radixSort

fun main() {
    val myList = arrayListOf(52, 23, 27, 0, 25, 13, 41, 6, 5, 3, 14)
    println("The original list: $myList")
    radixSort(myList)
    println("The sorted list: $myList")
}