package stack

/**
 * Created by Hojat Ghasemi on 2022-02-01.
 *The author could be contacted at "https://twitter.com/hojat_93"
 */
interface Stackable<T> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?

    val count: Int

    // This parameter is defined inside an interface, but it already has its own implementation;
    // so, the IDE doesn't force the Stack class to implement it.
    val isEmpty: Boolean
        get() = count == 0
}