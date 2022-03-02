package tree

/**
 * @author Hojat Ghasemi,
 * 2022-03-02
 * https://github.com/hojat72elect
 */
class BinaryTreeNode<T>(val value: T) {

    var leftChild: BinaryTreeNode<T>? = null
    var rightChild: BinaryTreeNode<T>? = null

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


}