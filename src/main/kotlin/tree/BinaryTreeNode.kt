package tree

/**
 * @author Hojat Ghasemi,
 * 2022-03-02
 * https://github.com/hojat72elect
 */
class BinaryTreeNode<T>(val value: T) {
    var leftChild: BinaryTreeNode<T>? = null
    var rightChild: BinaryTreeNode<T>? = null
}