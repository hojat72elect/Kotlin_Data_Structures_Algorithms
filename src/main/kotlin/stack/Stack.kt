package stack

/**
 * Created by Hojat Ghasemi on 2022-02-01.
 *The author could be contacted at "https://twitter.com/hojat_93"
 *
 * The code that book had written for this data structure was incorrect; I changed it this way.
 *
 * Remember that this class is only for educational purposes and isn't suitable for production purposes by any means (mostly because it's using an "ArrayList" to implement a "Stack"). For any professional purposes, only use "java.lang.Stack".
 */

class Stack<Element : Any> : Stackable<Element> {
    private val storage = arrayListOf<Element>()

    companion object {
        fun <Element : Any> create(items: Iterable<Element>): Stack<Element> {
            val tempStack = Stack<Element>()
            for (item in items) {
                tempStack.push(item)
            }
            return tempStack
        }
    }

    override val count: Int
        get() = storage.size

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("    $it    ")
        }
        appendLine("---bottom--")
    }

    override fun push(element: Element) {
        storage.add(element)
    }

    override fun pop(): Element? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(count - 1)
    }

    override fun peek(): Element? {
        return storage.lastOrNull() // Returns the last element of the ArrayList but the main ArrayList won't be changed.
    }
}

/**
 * This is a first-class function which is not part of Stack class but we just put in here for packaging reasons.
 * This function is now callable from everywhere in our project.
 */
fun <Element : Any> stackOf(vararg elements: Element): Stack<Element> {
    return Stack.create(elements.asList())
}