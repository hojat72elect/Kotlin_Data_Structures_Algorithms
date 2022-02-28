import linkedlist.LinkedList

fun main() {
    println(45 + 76)
    val myLinkedList = LinkedList<Int>()
    println(myLinkedList)
    myLinkedList
        .push(12)
        .push(13)
        .push(43)
        .push(3)
    println(myLinkedList)
}