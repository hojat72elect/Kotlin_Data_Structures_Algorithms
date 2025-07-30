package leetcode_problems

import java.util.*

class Solution4 {
    fun isValid(s: String): Boolean {

        if (s.length % 2 != 0)
            return false

        if ("]})".contains(s.first()))
            return false

        val primaryStack = Stack<Char>()
        val secondaryStack = Stack<Char>()

        for (parenthesis in s.reversed()) {
            primaryStack.push(parenthesis)
        }

        while (primaryStack.isNotEmpty()) {

            val itemFromPrimaryStack = primaryStack.pop()
            if ("([{".contains(itemFromPrimaryStack)) {
                // opening parentheses will be push to the second stack
                secondaryStack.push(itemFromPrimaryStack)
            } else {
                // this is a closing parenthesis
                if (secondaryStack.isEmpty())
                    return false
                val itemFromSecondaryStack = secondaryStack.pop()
                when (itemFromPrimaryStack) {
                    '}' -> {
                        if (itemFromSecondaryStack != '{')
                            return false
                    }

                    ']' -> {
                        if (itemFromSecondaryStack != '[')
                            return false
                    }

                    ')' -> {
                        if (itemFromSecondaryStack != '(')
                            return false
                    }
                }
            }
        }

        if (secondaryStack.isNotEmpty())
            return false

        return true
    }
}

fun main() {
    val solution = Solution4()
    println(solution.isValid("[]{[[}"))
}