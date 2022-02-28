package _stack

class HojatStack<T> {
    private val storage = arrayListOf<T>()

    val isEmpty: Boolean
        get() = storage.size == 0

    val size: Int
        get() = storage.size

    fun push(element: T): HojatStack<T> {
        storage.add(element)
        return this
    }

    fun pop(): T? {
        if (isEmpty) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

    override fun toString(): String {
        if (size == 0) {
            return "empty stack"
        }
        return buildString {
            appendLine("---top---")
            storage.asReversed().forEach {
                appendLine(it.toString())
            }
            appendLine("---bottom---")
        }
    }

    // just tells you what you will get if you pop the stack.
    fun peek(): T? {
        return storage[size - 1]
    }

}