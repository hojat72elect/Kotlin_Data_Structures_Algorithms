import Stack.Stack

fun main() {

    val myStack = Stack<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
    }
    println(myStack)
    val poppedElement = myStack.pop()
    if (poppedElement != null) {
        println("popped: $poppedElement")
    }
    println(myStack)
}