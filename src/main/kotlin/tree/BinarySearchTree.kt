package tree

/**
 * @author Hojat Ghasemi,
 * 2022-03-05
 * https://github.com/hojat72elect
 */
class BinarySearchTree<T : Comparable<T>> {
    var root: BinaryTreeNode<T>? = null
    override fun toString() = root?.toString() ?: "empty tree"

    /**
     * the BST takes care of insertions via a private function
     * which isn't accessible by other classes. you feed the
     * intended value and node to the function, and it returns
     * the result as a node. this private function is meant to
     * only work on BinaryTreeNodes not on a BinarySearchTree.
     */
    private fun insert(node: BinaryTreeNode<T>?, value: T): BinaryTreeNode<T> {
        node ?: return BinaryTreeNode(value)
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        return node
    }

    fun insert(value: T): BinarySearchTree<T> {
        root = insert(root, value)
        return this
    }

    /**
     * This is an optimized function that has a time complexity of O(log(n))
     * (but only if it's a balanced binary tree). Because it makes use of
     * characteristics of a Binary Search Tree.
     */
    fun contains(value: T): Boolean {
        var current = root
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }

    /**
     * removing a specific value from a Binary Search Tree
     */

    private fun remove(
        node: BinaryTreeNode<T>?,
        value: T
    ): BinaryTreeNode<T>? {

        node ?: return null
        when {
            (value == node.value) -> {
                if (node.leftChild == null && node.rightChild == null) {
                    // this is a leaf node
                    return null
                } else if (node.leftChild == null) {
                    // this node has only one child, return that.
                    return node.rightChild
                } else if (node.rightChild == null) {
                    // this node has only one child, return that.
                    return node.leftChild
                } else {
                    node.rightChild?.min?.value?.let {
                        node.value = it
                    }
                    node.rightChild = remove(node.rightChild, node.value)
                }
            }
            (value < node.value) -> {
                node.leftChild = remove(node.leftChild, value)
            }
            else -> {
                node.rightChild = remove(node.rightChild, value)
            }
        }
        return node
    }


}

