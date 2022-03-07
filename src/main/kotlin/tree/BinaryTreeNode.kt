package tree

/**
 * @author Hojat Ghasemi,
 * 2022-03-02
 * https://github.com/hojat72elect
 *
 * This class is the building block for all kinds of binary
 * trees, including "binary tree" and "binary search tree".
 */
class BinaryTreeNode<T>(var value: T) {

    var leftChild: BinaryTreeNode<T>? = null
    var rightChild: BinaryTreeNode<T>? = null

    /**
     * this "min" property will return the left-most sub-node
     * of this node. I will only need this for performing removal
     * operation on a binary search tree.
     */
    val min: BinaryTreeNode<T>
        get() = leftChild?.min ?: this

    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryTreeNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(
                    node.leftChild,
                    "$bottom│ ", "$bottom└──", "$bottom "
                )
            }
        } ?: "${root}null\n"
    }

    /**
     * In-order traversal first visits the left children (in a recursive fashion) and then visits the tree node itself and
     * finally goes for the left child of that node.
     */
    fun inOrderTraversal(visit: (it: BinaryTreeNode<T>?) -> Any) {
        this.leftChild?.inOrderTraversal(visit)
        visit(this)
        this.rightChild?.inOrderTraversal(visit)
    }

    /**
     * Pre-order traversal first visits the node itself and then visits the left and right nodes recursively.
     */
    fun preOrderTraversal(visit: (it: BinaryTreeNode<T>?) -> Any) {
        visit(this)
        this.leftChild?.preOrderTraversal(visit)
        this.rightChild?.preOrderTraversal(visit)
    }

    /**
     * Post-order traversal first visits the left and right children
     * recursively. The node itself will only be visited after its children are already met.
     */
    fun postOrderTraversal(visit: (it: BinaryTreeNode<T>?) -> Any) {
        this.leftChild?.postOrderTraversal(visit)
        this.rightChild?.postOrderTraversal(visit)
        visit(this)
    }
}