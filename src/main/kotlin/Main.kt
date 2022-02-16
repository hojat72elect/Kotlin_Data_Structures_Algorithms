import linkedlist.LinkedList
import linkedlist.Node

fun main() {
    val cities = LinkedList<String>()
    cities.push("Ottawa")
        .push("Toronto")
        .append("Vancouver")
        .push("Montreal")
        .append("Montreal")
    println(cities)
    cities.insert("Calgary", Node("Montreal", null))
    println(cities)
}