fun main() {

    val myList = LinkedList<Int>()
    myList.push(12).append(6).append(89).push(-4).push(56).append(8)
    println(myList)
    println(myList.nodeAt(3)?.let { myList.removeAfter(it) })
    println(myList)
}