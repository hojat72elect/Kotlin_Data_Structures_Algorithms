package stack

/**
 * @author Hojat Ghasemi,
 * 2022-02-27
 * https://github.com/hojat72elect
 *
 * language-independent Implementation of Stack data structure.
 */
class Stack<T>() : Stackable<T> {
    private val storage = arrayListOf<T>()

    override fun toString(): String {
        if (storage.size == 0) {
            return "Empty Stack"
        }
        return buildString {
            appendLine("---top---")
            storage.asReversed().forEach {
                appendLine("$it")
            }
            appendLine("---bottom---")
        }
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