package leetcode

fun main() {
    println(Matrix2D())
}

class Matrix2D {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (i in matrix.indices) {
            if (matrix[i][0] <= target && matrix[i][matrix[i].size] >= target) {
                for (j in matrix[i].indices) {
                    if (matrix[i][j] == target) {
                        return true
                    }
                }
            } else {
                continue
            }
        }
        return false
    }
}