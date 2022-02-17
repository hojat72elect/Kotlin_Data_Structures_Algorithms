import linkedlist.LinkedList
import linkedlist.Node

fun main() {
    val cities = LinkedList<String>()
    cities.push("Ottawa")
        .push("Toronto")
        .append("Vancouver")
        .push("Montreal")
        .append("Sudbury")
    cities.nodeAt(1)?.let { cities.insert("Calgary", it) }
    println(cities)
}