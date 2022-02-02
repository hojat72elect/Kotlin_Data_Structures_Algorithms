import stack.Stack
import stack.stackOf

fun main() {
    val myStack = Stack<Int>()
    println("my empty stack is like this:\n$myStack")

    myStack.apply {
        push(4)
        push(3)
        push(1)

    }
    println("my pushed stack is:\n$myStack")

    println("we poped '${myStack.pop()}' from the stack and now it is:\n$myStack")

    println("let's have a peek at the top:${myStack.peek()}\nbut the stack still is:\n$myStack")

    println("\n------------------------------\nSecond Example:")
    val mySecondStack = Stack.create(arrayListOf("a", "b", "c", "d"))
    println("my second stack out of an iterable is:\n$mySecondStack")
    println("popped:${mySecondStack.pop()}")

    println("\n------------------------------\nThird Example:")
    val myThirdStack = stackOf(4, 8, 3, 5)
    println("my third stack: \n$myThirdStack")

}