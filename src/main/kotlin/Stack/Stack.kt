package Stack

/**
 * Created by Hojat Ghasemi on 2022-02-01.
 *The author could be contacted at "https://twitter.com/hojat_93"
 *
 * The code that book had written for this data structure was incorrect; I changed it this way.
 *
 * Remember that this class is only for educational purposes and isn't suitable for production purposes by any means (mostly because it's using an "ArrayList" to implement a "Stack"). For any professional purposes, only use "java.lang.Stack".
 */

interface PushPop<Element> {
    fun push(element: Element)
    fun pop(): Element?
    fun peek(): Element?

    val count: Int
        get

    // This parameter is defined inside an interface but it already has its own implementation;
    // so, the IDE doesn't force the Stack class to implement it.
    val isEmpty: Boolean
        get() = count == 0
}

class Stack<T : Any>() : PushPop<T> {
    private val storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("-----------")
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    override fun peek(): T? {
        return storage.lastOrNull() // Returns the last element of the ArrayList but the main ArrayList won't be changed.
    }
}