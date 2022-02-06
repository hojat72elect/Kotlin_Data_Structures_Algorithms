import tree.TreeNode

fun main() {

    val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")

    val beverages = TreeNode("Beverages").run {
        add(hot)
        add(cold)
    }
    println(beverages)
    //it's because those add methods return boolean(it can be a possible issue with our current implementation).

}