fun main() {

    val myList = LinkedList<Int>()
    myList.push(12).append(6).append(89).push(-4).push(56).append(8)
    println(myList)

    for (item in myList) {
        println("The item is $item and its trippled value: ${item * 3}")
    }
}