package sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-15
 * https://github.com/hojat72elect
 */

fun <T : Comparable<T>> heapSort(inputList: MutableList<T>) {
    // build a heap
    for (i in (inputList.size / 2 - 1) downTo 0) {
        heapify(inputList, inputList.size, i)
    }
    // one by one, extract the max element from heap and
    // replace it with the last element in the array.

    for (i in (inputList.size - 1) downTo 0) {
        // arrA[0] is a root of the heap and is the max element
        // in the heap.
        inputList[0] = inputList[i].also {
            inputList[i] = inputList[0]
        } // just swapping the 0-th and i-th elements of the inputList
        // with each other.

        // call max heapify on the reduced heap
        heapify(inputList, i, 0)
    }
}

private fun <T : Comparable<T>> heapify(inputList: MutableList<T>, heapSize: Int, i: Int) {

    var largest = i //initialize largest as root
    val leftChildldx = 2 * i + 1 // left = 2*i + 1
    val rightChildldx = 2 * i + 2 // right = 2*i + 2

    // if left child is larger than root
    if (leftChildldx < heapSize && inputList[leftChildldx] > inputList[largest]) {
        largest = leftChildldx
    }

    // if right child is larger than root
    if (rightChildldx < heapSize && inputList[rightChildldx] > inputList[largest]) {
        largest = rightChildldx
    }

    //if largest isn't root
    if (largest != i) {
        val swap = inputList[i]
        inputList[i] = inputList[largest]
        inputList[largest] = swap

        // recursive call to heapify the subtree
        heapify(inputList, heapSize, largest)
    }

}
