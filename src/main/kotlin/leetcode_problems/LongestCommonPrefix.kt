package leetcode_problems

class Solution2 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty())
            return ""

        if (strs.size == 1)
            return strs[0]

        var commonPrefix = strs[0]
        for (i in 1 until strs.size) {
            commonPrefix = commonPrefix.commonPrefixWith(strs[i])
            if (commonPrefix.isEmpty())
                return ""
        }
        return commonPrefix
    }
}

fun main() {
    val solution = Solution2()
    println(solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(solution.longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}