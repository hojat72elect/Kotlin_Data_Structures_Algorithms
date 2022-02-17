package linkedlist

class LinkedList<T> : MutableCollection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size = 0
        private set
    // todo: the methods defined so far, change the original list (have side effects).
    // They should just edit a copy of the list and then return it.

    // This function is from Iterable<T> interface
    override fun iterator(): MutableIterator<T> {
        // you need to define a private class of your own that implements Iterator<T>
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

    override fun contains(element: T): Boolean {
        for (item in this) {
            return (item == element)
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

    //returns the value that was removed from front of the list.
    fun pop(): T? {
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

    // Removes the tail of the list. This one is a bit hard
    // because we need to get a reference to the node before tail.
    fun removeLast(): T? {
        //todo: it has side-effects.
        val head = head ?: return null
        if (head.next == null) {
            return this.pop()// pop() will handle everything on its own (even updating the size)
        }
        size--

        var previousNode = head
        var currentNode = head
        var nextNode = currentNode.next

        while (nextNode != null) {
            previousNode = currentNode
            currentNode = nextNode
            nextNode = nextNode.next
        }

        tail = previousNode
        previousNode.next = null
        return currentNode.value

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

    // Adds an element in front of LinkedList; always returns true, unless there was a problem in performing the append.
    override fun add(element: T): Boolean {
        this.append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            this.append(element)
        }
        return true
    }

    override fun clear() {
        this.head = null
        this.tail = null
        this.size = 0
    }

    override fun remove(element: T): Boolean {
        while (iterator().hasNext()) {
            if (iterator().next() == element) {
                iterator().remove()
                return true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        var result = true
        for (element in elements) {
            result = this.remove(element) && result
        }
        return result // The result will be true if all elements were removed (otherwise false)
    }

    // Other than elements mentioned in this function, remove
    // all the other elements in the LinkedList
    override fun retainAll(elements: Collection<T>): Boolean {
        var result = false
        while (this.iterator().hasNext()) {
            if (!elements.contains(this.iterator().next())) {
                iterator().remove()
                result = true
            }
        }
        return result
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

    // This function is from Iterator<T> interface
    override fun hasNext(): Boolean {
        return currentIndex < list.size
    }

    /**
     * the name of this method is misleading; even though it's named "next", you're supposed to return the value of
     * element at the currentIndex and then increment the currentIndex.
     *
     * This function is from Iterator<T> interface
     */
    override fun next(): T {
        if (!hasNext()) throw IndexOutOfBoundsException()

        currentNode = list.nodeAt(currentIndex)
        currentIndex++
        return currentNode!!.value
    }

    override fun remove() {
        if (currentIndex == 0) {
            // we're at the start of the LinkedList, just pop it.
            list.pop()
        } else {
            // get a reference to the previous node
            val prevNode = list.nodeAt(currentIndex - 1) ?: return
            list.removeAfter(prevNode) // This method will take care of everything for us.
            currentNode = prevNode
            currentIndex--
        }
    }
}
