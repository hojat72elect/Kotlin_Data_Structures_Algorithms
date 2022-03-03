import tree.BinaryTreeNode

fun main() {
    val zero = BinaryTreeNode(0)
    val one = BinaryTreeNode(1)
    val five = BinaryTreeNode(5)
    val seven = BinaryTreeNode(7)
    val eight = BinaryTreeNode(8)
    val nine = BinaryTreeNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    val tree = seven
    println("$tree\n")
    println("\nIf we traverse the tree in-order, this is what we get:")
    tree.inOrderTraversal { println(it?.value) }
    println("\nIf we traverse the tree pre-order, this is what we get:")
    tree.preOrderTraversal { println(it?.value) }
    println("\nIf we traverse the tree post-order, this is what we get:")
    tree.postOrderTraversal { println(it?.value) }

}