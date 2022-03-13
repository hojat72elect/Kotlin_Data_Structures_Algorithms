package sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-13
 * https://github.com/hojat72elect
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