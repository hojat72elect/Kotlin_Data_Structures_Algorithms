import sort.bubbleSort

fun main() {
    val mylist = arrayListOf(7, -3, 5, -7, 3, 4, -5, 3, 7, 4, 54, 35)
    println(mylist)
    bubbleSort(mylist, false)
    println(mylist)
}