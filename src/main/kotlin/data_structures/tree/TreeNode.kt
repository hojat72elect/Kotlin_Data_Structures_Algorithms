package data_structures.tree

import data_structures.queue.Queue


/**
 * Created by Hojat Ghasemi on 2022-02-06.
 *The author could be contacted at "https://twitter.com/hojat_93"
 */
class TreeNode<T>(val value: T) {

    /** The normal constructor of the node just accepts a single
     * value and makes a null list of nodes as the children of
     * that node, by default.*/
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    /**
     * Adds a single child to a tree node (that child might have children of its own).
     */
    fun add(child: TreeNode<T>): TreeNode<T> {
        children.add(child)
        return this
    }

    fun forEachDepthFirst(visit: (it: TreeNode<T>) -> Any) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachWidthFirst(visit: (it: TreeNode<T>) -> Any) {
        visit(this)
        val queue = Queue<TreeNode<T>>()
        this.children.forEach { queue.enqueue(it) }
        var node = queue.dequeue()

        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }

    }

    fun searchDepthFirst(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        this.forEachDepthFirst {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }

    fun searchWidthFirst(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        this.forEachWidthFirst {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }

}