package tree


/**
 * Created by Hojat Ghasemi on 2022-02-06.
 *The author could be contacted at "https://twitter.com/hojat_93"
 */
class TreeNode<T>(val value: T) {
    // The normal constructor of the node just accepts a single
    // value and makes a null list of nodes as the children of
    // that node, by default.
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    /**
     * Adds a single child to a tree node (that child might have children of its own).
     */
    fun add(child: TreeNode<T>) = children.add(child)

}