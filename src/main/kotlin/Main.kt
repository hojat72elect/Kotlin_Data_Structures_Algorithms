import linkedlist.LinkedList

fun main() {
    val list: MutableCollection<Int> = LinkedList()
    list.add(3)
    list.add(2)
    list.add(1)
    println(list)
    list.remove(1)
    println(list)
}