import queue.ArrayListQueue

fun main() {

    val peopleInQueue = ArrayListQueue<String>()
    peopleInQueue.enqueue("Hojat")
    peopleInQueue.enqueue("Hesam")
    peopleInQueue.enqueue("Hamed")
    peopleInQueue.enqueue("Jila")
    peopleInQueue.enqueue("Mansour")

    println("current people in queue:\n$peopleInQueue")
    println("first in queue: ${peopleInQueue.dequeue()}")
    println("next up is:${peopleInQueue.peek()}")

}