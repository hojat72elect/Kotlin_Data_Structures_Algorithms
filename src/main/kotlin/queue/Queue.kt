package queue

/**
 * Created by Hojat Ghasemi on 2022-02-02.
 *The author could be contacted at "https://twitter.com/hojat_93"
 *
 * my implementation for a Queue, it's implemented via an "ArrayList" and not suitable for production.
 * Only read it for educational purposes.
 *
 * One of the best classes you can use for implementing Queues in production is "java.util.concurrent.ArrayBlockingQueue".
 */
class Queue<T> {
    // Thanks to this ArrayList, the queue implemented in here
    // will have variable size.
    private val list = arrayListOf<T>()

    val size: Int
        get() = list.size

    // Shows you the first element of the queue.
    fun peek(): T? = list.getOrNull(0)

    fun enqueue(element: T): Queue<T> {
        list.add(element)
        return this
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun dequeue(): T? =
        if (isEmpty()) null else list.removeAt(0)

    /**
     * For debugging purposes, we needed to override the toString() method of this class.
     */
    override fun toString(): String = list.toString()
}