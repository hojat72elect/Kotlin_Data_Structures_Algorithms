import tree.TreeNode

fun main() {
    val people = TreeNode("people")
        .add(TreeNode("Lud").add(TreeNode("21")))
        .add(TreeNode("Esther"))
    println(people)
    people.forEachDepthFirst { println(it.value) }
    people.forEachWidthFirst { println(it.value) }

    println("the tree containing Lud\'s age: ${people.searchDepthFirst("21")?.value}")
    println("the tree containing Esther\'s age: ${people.searchWidthFirst("esther_age")?.value}")

}