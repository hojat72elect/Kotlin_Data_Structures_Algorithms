package leetcode_problems


/**
 * This is Leetcode 217
 */
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {

        val areAllItemsUnique = nums.toSet().size == nums.size
        return areAllItemsUnique.not()
    }
}