import linkedlist.LinkedList

fun main() {
    val cities = LinkedList<String>()
    cities.push("Ottawa")
        .push("Toronto")
        .append("Vancouver")
        .push("Montreal")
        .append("Sudbury")
    cities.nodeAt(1)?.let { cities.insert("Calgary", it) }
    println(cities)
    cities.pop()
    println(cities)
    println("We removed the last item which is: ${cities.removeLast()}")
    println(cities)
}