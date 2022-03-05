import tree.BinarySearchTree

fun main() {
    val numberTree = BinarySearchTree<Int>()

    // Creating a BST:
    numberTree.insert(12)
        .insert(23)
        .insert(1)
        .insert(-1)
        .insert(4)
        .insert(3)
        .insert(56)
        .insert(12)
        .insert(34)
        .insert(32)
        .insert(0)

    println(numberTree)

    if (numberTree.contains(34)) {
        println("the tree contains 34")
    } else {
        println("the tree doesn't contain 34")
    }


}