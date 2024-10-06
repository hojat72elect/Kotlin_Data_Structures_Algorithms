package algorithms.sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-15
 * https://github.com/hojat72elect
 *
 * The worst-case time complexity of HeapSort is O(n*log(n)). It's a comparison based sorting
 * algorithm which uses the notion of heaps (complete binary trees).
 */

fun <T : Comparable<T>> heapSort(inputList: MutableList<T>) {
    // build a max-heap
    for (i in (inputList.size / 2 - 1) downTo 0) {
        heapify(inputList, inputList.size, i)
    }
    // one by one, extract the max element from heap and
    // replace it with the last element in the array.

    for (i in (inputList.size - 1) downTo 0) {
        // inputList[0] is a root of the heap and is the max element
        // in the heap.
        inputList[0] = inputList[i].also {
            inputList[i] = inputList[0]
        } // just swapping the 0-th and i-th elements of the inputList
        // with each other.

        // call max heapify on the reduced heap
        heapify(inputList, i, 0)
    }
}

/**
 * It receives the inputList and converts it into a heap (thus called "heapify").
 * a heap is a complete binary tree; which means all the levels of this binary tree other than last level
 * are full of nodes. Furthermore, in a heap, all nodes are either >= (in a Max-Heap) or <=
 * (in a Min-Heap) to their children.
 *
 * The "heapify()" function I've written here creates a Max-Heap (parent is more than or equal to its children).
 */
private fun <T : Comparable<T>> heapify(inputList: MutableList<T>, heapSize: Int, i: Int) {
    var indexLargest = i //initialize largest as root
    val indexLeftChild = 2 * i + 1 // left = 2*i + 1
    val indexRightChild = 2 * i + 2 // right = 2*i + 2

    // if left child is larger than root
    if (indexLeftChild < heapSize && inputList[indexLeftChild] > inputList[indexLargest]) {
        indexLargest = indexLeftChild
    }

    // if right child is larger than root
    if (indexRightChild < heapSize && inputList[indexRightChild] > inputList[indexLargest]) {
        indexLargest = indexRightChild
    }

    // if indexLargest has been changed that means we need to swap the
    // parent with one of its children (right child has the higher priority).
    if (indexLargest != i) {
        inputList[i] = inputList[indexLargest].also { inputList[indexLargest] = inputList[i] } // swapping

        // this recursive call is to make sure that this specific
        // parent and its direct children comply with max-heap characteristics.
        heapify(inputList, heapSize, indexLargest)
    }
}
