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
}

class Stack<T : Any>() : PushPop<T> {
    private val storage = arrayListOf<T>()
    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendln("$it")
        }
        appendLine("-----------")
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        if (storage.size == 0) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }
}