import sort.mergeSort

fun main() {
    val mylist =
        arrayListOf(9, 4, 10, -3, -7, 3, -8, 6, 5, -9, 734, 65, 97, -38, 4, 6, 5, 39, 284, -7, 65, 3, 9, 8, -45)
    println(mylist)
    println(mergeSort(mylist))
}