package leetcode_problems

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { index, num ->
            var counter = index + 1
            while (counter < nums.size) {
                if (num + nums[counter] == target) {
                    return intArrayOf(index, counter)
                }
                counter++
            }
        }
        throw Exception("The input must offer at least one answer.")
    }
}

fun main() {
    val solution = Solution()

    // example 1
    val answer1 = solution.twoSum(intArrayOf(2, 7, 11, 15), 9)
    println(answer1.contentToString())
}