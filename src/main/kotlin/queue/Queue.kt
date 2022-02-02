package queue

/**
 * Created by Hojat Ghasemi on 2022-02-02.
 *The author could be contacted at "https://twitter.com/hojat_93"
 *
 * for production purposes, use "java.util.Queue" instead. This one is just for education.
 */
interface Queue<T> {

    /**
     * inserts an element at the back of the Queue.
     */
    fun enqueue(element: T): Boolean

    /**
     * removes and returns the element at the front of the Queue.
     */
    fun dequeue(): T?

    /**
     * returns the front element of the Queue without removing it.
     */
    fun peek(): T?

    val count: Int
        get

    //the getter for this property is already implemented.
    val isEmpty: Boolean
        get() = count == 0

}