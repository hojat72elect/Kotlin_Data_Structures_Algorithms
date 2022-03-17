package sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-16
 * https://github.com/hojat72elect
 *
 *
 * I love this naive implementation of quick sort. It's really efficient and extremely
 * easy to understand/implement. It's O(n*log(n)) in time complexity, but it's not too
 * efficient in memory consumption because of these reasons:
 *
 * 1- This implementation calls the filter() function on the same list for 3 times.
 * 2- It creates a new list for every partition (which isn't space efficient)
 * 3- It always picks the middle element as the pivot (which might not always be the best partitioning strategy)
 */
fun <T : Comparable<T>> quickSortNaive(inputList: List<T>): List<T> {
    // a list of size 1 is already sorted (the condition that will stop this recursion)
    if (inputList.size < 2) return inputList

    // initial pivot is the middle element
    val pivot = inputList[inputList.size / 2]
    // all elements that are less than pivot
    val less = inputList.filter { it < pivot }
    // all elements that are equal to pivot
    val equal = inputList.filter { it == pivot }
    // all the elements that are greater than pivot
    val greater = inputList.filter { it > pivot }

    // recursively quick sort the whole inputList
    return quickSortNaive(less) + equal + quickSortNaive(greater)

}