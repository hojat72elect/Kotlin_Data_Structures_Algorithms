package algorithms.sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-14
 * https://github.com/hojat72elect
 *
 * Merge sort:
 * this is a typical divide-and-conquer approach to sorting an algorithm.
 * the first part of algorithm is dividing the inputList in a recursive
 * fashion until there are lists with only 1 element (which means they're
 * already sorted).
 * In this step of the algorithm, if for example the inputList has 4 items, we'll
 * have 2 levels of recursive division, if there are 8 items, there will be 3
 * levels, if there are 1024 elements there will be 10 levels of division; and
 * consequently, if the number of elements in inputList is n, we'll have log2(n)
 * levels of division.
 *
 * The next step is to sort and merge the already sorted sub-lists in a recursive
 * fashion. The number of levels that this sort-and-merge operation will happen is
 * exactly the same as division levels (log2(n)) but pay attention that in each
 * level of it, exactly n elements are compared with each other and new sorted
 * lists created. So, in each level, exactly n comparison operations are performed.
 *
 * As a result, we have log(n) division operations and also n*log(n) merge-sort
 * operations. In the whole algorithm we have [log(n)+n*log(n)] operations which
 * makes this a O(nlog(n)) algorithm (according to time complexity).
 *
 */

fun <T : Comparable<T>> mergeSort(inputList: List<T>): List<T> {
    if (inputList.size == 1) return inputList // The base condition of the recursive division of inputList.

    // recursively dividing the inputList
    val middleIndex = inputList.size / 2
    val leftSubList = mergeSort(inputList.subList(0, middleIndex))
    val rightSubList = mergeSort(inputList.subList(middleIndex, inputList.size))

    return merge(leftSubList, rightSubList)
}

/**
 * simply merges 2 already sorted lists in a way
 * that the result will be a sorted list as well.
 * Remember: @param left and @param right should
 * be already sorted in order for this function
 * to work correctly.
 */
private fun <T : Comparable<T>> merge(left: List<T>, right: List<T>): List<T> {
    var leftIndex = 0
    var rightIndex = 0
    val result = mutableListOf<T>()

    // the problem with the condition of this while loop is that
    // both indices of sublists are checked at the same time. But,
    // there's a possibility that one sublist finishes sooner than
    // the other one. So, as a solution, after this while loop ends,
    // we need to check both of the indices of sublists separately
    while (leftIndex < left.size && rightIndex < right.size) {
        val rightElement = right[rightIndex]
        val leftElement = left[leftIndex]

        if (leftElement < rightElement) {
            result.add(leftElement)
            leftIndex++
        } else if (leftElement > rightElement) {
            result.add(rightElement)
            rightIndex++
        } else {
            // The 2 elements from sublists are the same
            result.add(leftElement)
            result.add(rightElement)
            leftIndex++
            rightIndex++
        }
    }

    if (leftIndex < left.size) {
        // there are still some elements in the left sublist
        result.addAll(left.subList(leftIndex, left.size))
    }
    if (rightIndex < right.size) {
        // there are still some elements in the right sublist
        result.addAll(right.subList(rightIndex, right.size))
    }
    return result
}