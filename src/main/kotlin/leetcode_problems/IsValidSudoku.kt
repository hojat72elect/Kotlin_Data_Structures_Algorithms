package leetcode_problems

import java.util.*

// leetcode 36
class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        // first check if the rows are valid
        board.forEach { row ->
            val cleanedRow = row.filter { it != '.' }
            if (cleanedRow.toSet().size != cleanedRow.size)
                return false
        }

        // Second check if the columns are valid
        for (columnIndex in 0 until 9) {
            val tempColumn = Stack<Char>()
            for (rowIndex in 0 until 9) {
                val item = board[rowIndex][columnIndex]
                if (item != '.')
                    tempColumn.push(item)
            }
            if (tempColumn.toSet().size != tempColumn.size)
                return false
        }
        return true //TODO : there's still one more step left.
    }
}

fun main() {
    val solution = Solution36()
    val board = arrayOf(
        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(solution.isValidSudoku(board))
}