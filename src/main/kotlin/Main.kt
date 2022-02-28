import _stack.HojatStack

fun main() {
    val myFaveCities = HojatStack<String>()

    println(myFaveCities)
    println("Since the stack is empty, the size is: ${myFaveCities.size}")

    myFaveCities
        .push("Toronto")
        .push("New York")
        .push("Sao Paolo")
        .push("Lisbon")

    println(myFaveCities)
    println("and the size of the stack above is: ${myFaveCities.size}")
    println("The first city that pops out is: ${myFaveCities.pop()}")
    println("After popping, the size has become: ${myFaveCities.size}")

    println("let's peek into next element: ${myFaveCities.peek()}")
    println(myFaveCities.pop())
    println(myFaveCities.pop())
    println(myFaveCities.pop())
    println(myFaveCities.pop())
    println(myFaveCities.pop())
    println("ok, is it empty now? ${myFaveCities.isEmpty}")
}
