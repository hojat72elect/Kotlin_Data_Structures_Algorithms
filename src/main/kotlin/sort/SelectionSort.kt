package sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-13
 * https://github.com/hojat72elect
 *
 * Selection sort:
 * Time complexity is O(n^2) - but it's easy to understand/implement.
 * swaps each element of the list with the minimum of all the elements
 * which come after it.
 */


fun <T : Comparable<T>> selectionSort(inputList: ArrayList<T>, showPasses: Boolean) {
    var counter1 = 0
    while (counter1 < inputList.size) {
        var minIndex = counter1
        for (counter2 in counter1 until inputList.size) {
            if (inputList[counter2] < inputList[minIndex]) {
                minIndex = counter2
            }
        }
        inputList.swap(counter1, minIndex)
        if (showPasses) println(inputList)
        counter1++
    }
}

//fun <T> ArrayList<T>.swap(first: Int, second: Int) {
//    this[first] = this[second].also { this[second] = this[first] }
//}