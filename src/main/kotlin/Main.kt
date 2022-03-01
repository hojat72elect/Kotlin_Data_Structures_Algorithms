import queue.Queue

fun main() {

    val myQueue = Queue<Int>()
    println(myQueue)
    println("Is it empty? ${myQueue.isEmpty()}\n")
    myQueue.enqueue(5)
        .enqueue(12)
        .enqueue(27)
    println(myQueue)

    println("The first element in queue: ${myQueue.peek()}\n")
    myQueue.dequeue()
    println("Now the queue is like this: $myQueue")
    println("current size: ${myQueue.size}")

    myQueue.enqueue(56)
    println("56 went to the queue: $myQueue")
    println(myQueue.dequeue())
    println(myQueue.dequeue())
    println(myQueue.dequeue())
    println(myQueue.dequeue())
    println(myQueue.dequeue())

}