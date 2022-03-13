package sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-12
 * https://github.com/hojat72elect
 *
 * Bubble sort:
 * Time complexity is O(n^2) - but it's easy to understand/implement and also space efficient.
 * Bubble sort repeatedly compares adjacent values and swaps them if needed.
 */
fun <T : Comparable<T>> bubbleSort(inputList: ArrayList<T>, showPasses: Boolean) {
    for (counter1 in 1 until inputList.size) {
        var swapped = false
        for (counter2 in 0..counter1) {
            if (counter2 + 1 < inputList.size) {
                if (inputList[counter2] > inputList[counter2 + 1]) {
                    inputList.swap(counter2, counter2 + 1)
                    swapped = true
                }
            }
        }
        if (showPasses) println(inputList)
        if (!swapped) return
    }
}

fun <T> ArrayList<T>.swap(first: Int, second: Int) {
    this[first] = this[second].also { this[second] = this[first] }
}