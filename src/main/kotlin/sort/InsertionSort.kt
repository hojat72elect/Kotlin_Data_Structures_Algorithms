package sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-13
 * https://github.com/hojat72elect
 */


fun <T : Comparable<T>> insertionSort(inputList: ArrayList<T>, showPasses: Boolean) {
    for (counter1 in 1 until inputList.size) {
        // counter1 goes through all the elements of the input list other than the first one.
        for (counter2 in (1..counter1).reversed()) {
            // counter2 keeps checking the new number with the numbers currently in the sorted list.
            if (inputList[counter2] < inputList[counter2 - 1]) {
                inputList.swap(counter2, counter2 - 1)
            } else {
                break
            }
        }
        if (showPasses) println(inputList)
    }
}

//fun <T> ArrayList<T>.swap(first: Int, second: Int) {
//    this[first] = this[second].also { this[second] = this[first] }
//}