package sort

/**
 * @author Hojat Ghasemi,
 * 2022-03-14
 * https://github.com/hojat72elect
 *
 * This implementation of Radix Sort that I have in here is extremely limited.
 * First, all items in the inputList must be non-negative integers; otherwise
 * this function will throw errors. And also it doesn't work on float or other types
 * of numbers in JVM, only on Int.
 *
 * But the worst-case time complexity of it is O(k*n) where k is the number of digits
 * in the biggest input integer and n is the number of integers in the input list
 */

fun radixSort(inputList: MutableList<Int>) {


    var finished = false // a flag for whether we are finished or not
    var digits = 1 // current digit we're looking at
    while (!finished) {
        finished = true
        val buckets = arrayListOf<MutableList<Int>>().apply {
            for (i in 0..9) {
                this.add(arrayListOf())
            }
        } // a 2D array that contains the buckets of each digit at each level.
        inputList.forEach { number ->

            // Our buckets will be according to base 10
            val digit = (number / digits) % 10
            buckets[digit].add(number)
            if (number / digits > 0) {
                finished = false
            }
        }
        digits *= 10

        inputList.clear()
        inputList.addAll(buckets.flatten())

    }

}