class LinkedList<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0
//todo: the methods defined so far, change the original list (have side effects). They should just edit a copy of the list and then return it.


    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty LinkedList"
        } else {
            return head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T> {
        if (isEmpty()) {
            push(value)
        } else {
            tail?.next = Node(value, null)
            tail = tail?.next
            size++
        }
        return this
    }

    fun nodeAt(index: Int): Node<T>? {
        var currentNode = head
        var currentIndex = 0
        while (currentIndex < index && currentNode != null) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>) {
        //todo: it has side effects.
        if (afterNode == tail) {
            this.append(value)
        } else {
            val newNode = Node(value, afterNode.next)
            afterNode.next = newNode
            size++
        }
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


}