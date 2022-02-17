package linkedlist

class LinkedList<T> : Collection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    override var size = 0
        private set
    //todo: the methods defined so far, change the original list (have side effects).
    // They should just edit a copy of the list and then return it.

    override fun iterator(): Iterator<T> {
        return LinkListIterator(this)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty LinkedList"
        } else {
            head.toString()
        }
    }

    // Adding an element in front of the LinkedList.
    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    // Adding an element at the end of the LinkedList.
    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
        } else {
            tail!!.next = Node(value, null)
            tail = tail?.next
            size++
        }
        return this
    }

    // In order to use "insert()" more easily, you need to
    // first have a reference to a node by using nodeAt().
    fun nodeAt(index: Int): Node<T>? {
        // The nature of LinkedList is that in order to
        // get to a specific node, you need to traverse through it.
        var currentNode = head
        var currentIndex = 0
        while (currentIndex < index && currentNode != null) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    // Inserting an element after a specific node of the LinkedList.
    fun insert(value: T, afterNode: Node<T>): LinkedList<T> {
        //todo: it has side effects.
        if (afterNode == tail) {
            this.append(value)
        } else {
            val newNode = Node(value, afterNode.next)
            afterNode.next = newNode
        }
        size++
        return this
    }

    fun pop(): T? {
        //returns the value that was removed from front of the list.
        //todo: side effects.
        if (!isEmpty()) {
            size--
        }
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        //removes the value that was at the end of the list.
        //todo: it has side-effects.
        val head = head ?: return null
        if (head.next == null) {
            return pop()
        }
        size--
        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value

    }

    fun removeAfter(node: Node<T>): T? {
        //todo: side-effects.
        val result = node.next?.value
        if (node.next == tail) {
            tail = node
        }
        if (node.next != null) {
            size--
        }
        node.next = node.next?.next
        return result
    }

    override fun contains(element: T): Boolean {
        for (item in this) {
            if (item == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        //this method isn't efficient; it's O(n^2)
        for (itemFromCollection in elements) {
            if (!this.contains(itemFromCollection)) return false
        }
        return true
    }
}

/**
 * you just feed the linkedlist.LinkedList to the constructor of this class,
 * and you will have an iterator that helps you work with the linkedlist.LinkedList.
 */
private class LinkListIterator<T>(
    private val list: LinkedList<T>
) : MutableIterator<T> {
    private var currentIndex = 0
    private var currentNode: Node<T>? = null

    override fun hasNext(): Boolean {
        return currentIndex < list.size
    }

    /**
     * the name of this method is misleading; even though it's named "next", you're supposed to return the value of
     * element at the currentIndex and then increment the currentIndex.
     */
    override fun next(): T {
        if (!this.hasNext()) throw IndexOutOfBoundsException()

        currentNode = list.nodeAt(currentIndex)
        currentIndex++
        return currentNode!!.value

    }

    override fun remove() {
        TODO("Not yet implemented")
    }
}
