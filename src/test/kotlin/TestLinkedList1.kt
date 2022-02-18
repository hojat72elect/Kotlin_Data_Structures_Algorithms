import linkedlist.LinkedList


/**
 * Created by Hojat Ghasemi on 2022-02-17.
 * The author could be contacted at "https://twitter.com/hojat_93"
 */
fun main() {
    val myFavoriteNums = LinkedList<Int>()
    println("Initial size upon creation: ${myFavoriteNums.size}")
    println("$myFavoriteNums")
    println("is it empty? ${myFavoriteNums.isEmpty()}\n")

    myFavoriteNums
        .push(34)
        .append(23)
        .push(12)
        .append(-12)
        .push(7)
    println("after a few pushing and appending, the LinkedList is tis: $myFavoriteNums")
    println("Is it still empty? ${myFavoriteNums.isEmpty()}")
    println("what about the size? ${myFavoriteNums.size}\n")

    println("first num: ${myFavoriteNums.nodeAt(0)!!.value}")
    println("number at index 3: ${myFavoriteNums.nodeAt(3)!!.value}\n")

    myFavoriteNums.insert(100, 2)
    println("after insertion, myFavoriteNums are: $myFavoriteNums")
    println("and now the size is: ${myFavoriteNums.size}\n")

    println("let's pop some numbers: ${myFavoriteNums.pop()} and then ${myFavoriteNums.pop()}")
    println("After that, myFavoriteNums is like this: $myFavoriteNums")
    println("And its size is: ${myFavoriteNums.size}\n")

    println("What if we remove the last element of these myFavoriteNums: ${myFavoriteNums.removeLast()}")
    println("After that, myFavoriteNums are: $myFavoriteNums and the size is ${myFavoriteNums.size}\n")

    println(myFavoriteNums)
    println("Is 34 among myFavoriteNums? ${myFavoriteNums.contains(34)}")
    println("Is 46 among myFavoriteNums? ${myFavoriteNums.contains(46)}")
    println("Are 100, 34, and 23 inside myFavoriteNums? ${myFavoriteNums.containsAll(listOf(100, 34, 23))}")
    println("Are 100, 35, and 23 inside myFavoriteNums? ${myFavoriteNums.containsAll(listOf(100, 35, 23))}\n")

    println(myFavoriteNums)
    println("What if I remove my second favorite number? it is ${myFavoriteNums.remove(1)}")
    println("and finally, my favorite numbers: $myFavoriteNums")
    println("The size: ${myFavoriteNums.size}")
}