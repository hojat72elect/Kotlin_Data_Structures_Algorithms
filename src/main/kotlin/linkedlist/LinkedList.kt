package linkedlist

class LinkedList<T>() {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0
        private set
    // the methods defined so far, change the original list (have side effects).
    // They should just edit a copy of the list and then return it.

    constructor(collection: Collection<T>) : this() {
        for (element in collection) {
            this.append(element)
        }
    }


    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty LinkedList"
        } else {
            head.toString()
        }
    }

    fun contains(element: T): Boolean {
        if (this.isEmpty()) {
            // An empty LinkedList can't contain any elements.
            return false
        } else {
            var currentIndex = 0
            while (currentIndex != size) {

                if (element == nodeAt(currentIndex)?.value) {
                    return true
                }
                currentIndex++
            }
            return false
        }
    }

    fun containsAll(elements: Collection<T>): Boolean {
        //this method isn't efficient; it's O(n^2)
        for (itemFromCollection in elements) {
            if (!this.contains(itemFromCollection)) return false
        }
        return true
    }

    // Adding an element in front of the LinkedList. Current instance of LinkedList()
    // is returned, so we can chain this function to other functions of this class.
    fun push(value: T): LinkedList<T> {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    // Adding an element at the end of the LinkedList. Current instance of LinkedList()
    // is returned, so we can chain this function to other functions of this class.
    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value) // push() takes care of increasing size, so we don't do it ourselves.
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
        if (index > this.size - 1 || index < 0) {
            throw ArrayIndexOutOfBoundsException("not valid index")
        }
        var currentNode = head
        var currentIndex = 0
        while (currentIndex < index) {
            currentNode = currentNode?.next
            currentIndex++
        }
        return currentNode
    }

    // the value will be inserted at this index and nodes before and after it need to be updated. The node that used to be at this index, will shift to right.
    fun insert(value: T, index: Int): LinkedList<T> {
        // It has side effects.
        if (index == 0) {
            push(value)
        } else {
            nodeAt(index - 1)?.next = Node(value, nodeAt(index))
            // Remember: the node that used to be in this index won't be
            // thrown away.
            size++
        }
        return this
    }

    //returns the value that was removed from front of the list.
    fun pop(): T? {
        return if (!isEmpty()) {
            val result = head?.value
            head = head?.next
            size--
            result
        } else {
            null
        }

    }

    // Removes the tail of the list and returns its value.
    fun removeLast(): T? {
        return if (isEmpty()) {
            null
        } else {
            if (size == 1) {
                this.pop()
            } else {
                val result = tail?.value
                tail = nodeAt(size - 2)
                tail?.next = null
                size--
                result
            }
        }
    }

    // It's a lot easier to implement compared to insert(). It removes the element at
    // the given index and returns the value of the node that used to be at that index.
    fun remove(index: Int): T? {
        if (index >= size) {
            throw ArrayIndexOutOfBoundsException("not valid index")
        }
        return if (isEmpty()) {
            null
        } else {
            val result = nodeAt(index)?.value
            nodeAt(index - 1)?.next = nodeAt(index + 1)
            size--
            result
        }
    }
}


