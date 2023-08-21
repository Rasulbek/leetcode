package leetcode

fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(ValidSudoku().isValidSudoku(board))
}

class ValidSudoku {

    lateinit var board: Array<CharArray>
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        this.board = board
        for (i in 0 until 9) {
            if (!checkSubBoard(i)) return false
            if (!checkHorizontal(i)) return false
            if (!checkVertical(i)) return false
        }


        return true
    }

    private fun checkSubBoard(idx: Int): Boolean {
        val set = HashSet<Char>()
        val i1 = (idx / 3) * 3
        val i2 = i1 + 3
        val j1 = (idx * 3) % 9
        val j2 = j1 + 3

        for (i in i1 until i2) {
            for (j in j1 until j2) {
                if (board[i][j] == '.') {
                    continue
                }
                if (!set.contains(board[i][j])) {
                    set.add(board[i][j])
                } else {
                    return false
                }
            }
        }

        return true
    }

    private fun checkHorizontal(idx: Int): Boolean {
        val set = HashSet<Char>()
        for (i in 0 until 9) {
            if (board[idx][i] == '.') {
                continue
            }
            if (!set.contains(board[idx][i])) {
                set.add(board[idx][i])
            } else {
                return false
            }
        }
        return true
    }


    private fun checkVertical(idx: Int): Boolean {
        val set = HashSet<Char>()
        for (i in 0 until 9) {
            if (board[i][idx] == '.') {
                continue
            }
            if (!set.contains(board[i][idx])) {
                set.add(board[i][idx])
            } else {
                return false
            }
        }
        return true
    }
}