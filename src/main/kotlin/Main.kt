fun main() {

    val myList = LinkedList<Int>()
    myList.push(12).append(6).append(89).push(-4).push(56).append(8)
    println("The LinkedList is: $myList\n and the size is: ${myList.size}")

    println(12 in myList)
    println(myList.containsAll(listOf(12, 6, 89)))
    println(myList.containsAll(listOf(1)))


}