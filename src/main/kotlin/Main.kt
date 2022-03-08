import search._binarySearch

fun main() {

    val myNumbers = arrayListOf(16, 29, 37, 42, 83, 23, 75)
    println("The numbers at first: $myNumbers")
    println("The result of binary search on a non-incrementally-sorted array: ${myNumbers._binarySearch(3)}")
    myNumbers.sort()
    println("numbers after being incrementally sorted: $myNumbers")
    println("the index of 2: ${myNumbers._binarySearch(2)}")
    println("the index of 16: ${myNumbers._binarySearch(16)}")
    println("the index of 23: ${myNumbers._binarySearch(23)}")
}