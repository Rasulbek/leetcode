package leetcode

import java.util.*
import kotlin.collections.HashSet
import kotlin.math.min


fun main() {
//    println(
//        Matrix01().updateMatrix(
//            arrayOf(
//                arrayOf(0, 0, 0).toIntArray(),
//                arrayOf(0, 1, 0).toIntArray(),
//                arrayOf(0, 0, 0).toIntArray()
//            )
//        )
//    )
//    println(
//        Matrix01().updateMatrix(
//            arrayOf(
//                arrayOf(0, 0, 0).toIntArray(),
//                arrayOf(0, 1, 0).toIntArray(),
//                arrayOf(1, 1, 1).toIntArray()
//            )
//        )
//    )
//    println(
//        Matrix01().updateMatrix(
//            arrayOf(
//                arrayOf(1, 1, 0, 0, 1, 0, 0, 1, 1, 0).toIntArray(),
//                arrayOf(1, 0, 0, 1, 0, 1, 1, 1, 1, 1).toIntArray(),
//                arrayOf(1, 1, 1, 0, 0, 1, 1, 1, 1, 0).toIntArray(),
//                arrayOf(0, 1, 1, 1, 0, 1, 1, 1, 1, 1).toIntArray(),
//                arrayOf(0, 0, 1, 1, 1, 1, 1, 1, 1, 0).toIntArray(),
//
//                arrayOf(1, 1, 1, 1, 1, 1, 0, 1, 1, 1).toIntArray(),
//                arrayOf(0, 1, 1, 1, 1, 1, 1, 0, 0, 1).toIntArray(),
//                arrayOf(1, 1, 1, 1, 1, 0, 0, 1, 1, 1).toIntArray(),
//                arrayOf(0, 1, 0, 1, 1, 0, 1, 1, 1, 1).toIntArray(),
//                arrayOf(1, 1, 1, 0, 1, 0, 1, 1, 1, 1).toIntArray(),
//
//                )
//        )
//    )
    println(
        Matrix01().updateMatrix(
            arrayOf(
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(1, 1, 1).toIntArray(),
                arrayOf(0, 0, 0).toIntArray(),
            )
        )
    )
//    println(
//        Matrix01().updateMatrix(
//            arrayOf(
//                arrayOf(0).toIntArray(),
//                arrayOf(1).toIntArray()
//            )
//        )
//    )
//    println(
//        Matrix01().updateMatrix(
//            arrayOf(
//                arrayOf(0, 1).toIntArray(),
//            )
//        )
//    )
}

class Matrix01 {
    lateinit var result: Array<IntArray>
    lateinit var matrix: Array<IntArray>
    var rows: Int = 0
    var cols: Int = 0
    var lastZero = 0
    var firstZero = 0
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        matrix = mat.copyOf()
        result = Array<IntArray>(mat.size) { IntArray(mat[0].size) { -1 } }
        rows = mat.size
        cols = mat[0].size
        var topildi = false
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0
                    if (!topildi) {
                        firstZero = i
                        topildi = true
                    }
                    lastZero = i
                }
            }
        }

        for (i in lastZero until mat.size) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) {
                    continue
                }
                val path = HashSet<String>()
                path.add(pair(i, j))
                result[i][j] = calculate(i, j, path, 10000)
            }
        }
        var i = lastZero
        while (i >= 0) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) {
                    continue
                }
                val path = HashSet<String>()
                path.add(pair(i, j))
                result[i][j] = calculateTeskari(i, j, path, 10000)
            }
            i--
        }
        return result
    }

    fun calculate(i: Int, j: Int, path: HashSet<String>, foundMin: Int): Int {
        if (path.size >= foundMin) {
            return foundMin
        }
        if (result[i][j] == 0) {
            return path.size - 1
        }
        if (result[i][j] != -1) {
            return result[i][j] + (path.size - 1)
        }

        var minWay = 100000
        if (j >= 1 && !path.contains(pair(i, j - 1))) {
            val left = if (result[i][j - 1] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i, j - 1))
                }
                calculate(i, j - 1, newPath, minWay)
            } else {
                result[i][j - 1] + path.size
            }
            if (left < minWay) minWay = left
        }
        if (i >= 1 && !path.contains(pair(i - 1, j))) {
            val top = if (result[i - 1][j] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i - 1, j))
                }
                calculate(i - 1, j, newPath, minWay)
            } else {
                result[i - 1][j] + path.size
            }
            if (top < minWay) minWay = top
        }
        if (j < cols - 1 && !path.contains(pair(i, j + 1))) {
            val right = if (result[i][j + 1] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i, j + 1))
                }
                calculate(i, j + 1, newPath, minWay)
            } else {
                result[i][j + 1] + path.size
            }
            if (right < minWay) minWay = right
        }
        if (i < rows - 1 && !path.contains(pair(i + 1, j))) {
            val bottom = if (result[i + 1][j] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i + 1, j))
                }
                calculate(i + 1, j, newPath, minWay)
            } else {
                result[i + 1][j] + path.size
            }
            if (bottom < minWay) minWay = bottom
        }

        return minWay
    }

    fun calculateTeskari(i: Int, j: Int, path: HashSet<String>, foundMin: Int): Int {
        if (path.size >= foundMin) {
            return foundMin
        }
        if (result[i][j] == 0) {
            return path.size - 1
        }
        if (result[i][j] != -1) {
            return result[i][j] + (path.size - 1)
        }

        var minWay = 100000
        if (i < rows - 1 && !path.contains(pair(i + 1, j)) && i < lastZero) {
            val bottom = if (result[i + 1][j] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i + 1, j))
                }
                calculateTeskari(i + 1, j, newPath, minWay)
            } else {
                result[i + 1][j] + path.size
            }
            if (bottom < minWay) minWay = bottom
        }
        if (j < cols - 1 && !path.contains(pair(i, j + 1))) {
            val right = if (result[i][j + 1] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i, j + 1))
                }
                calculateTeskari(i, j + 1, newPath, minWay)
            } else {
                result[i][j + 1] + path.size
            }
            if (right < minWay) minWay = right
        }
        if (j >= 1 && !path.contains(pair(i, j - 1))) {
            val left = if (result[i][j - 1] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i, j - 1))
                }
                calculateTeskari(i, j - 1, newPath, minWay)
            } else {
                result[i][j - 1] + path.size
            }
            if (left < minWay) minWay = left
        }
        if (i >= 1 && !path.contains(pair(i - 1, j)) && i > firstZero) {
            val top = if (result[i - 1][j] == -1) {
                val newPath = HashSet<String>().apply {
                    addAll(path)
                    add(pair(i - 1, j))
                }
                calculateTeskari(i - 1, j, newPath, minWay)
            } else {
                result[i - 1][j] + path.size
            }
            if (top < minWay) minWay = top
        }


        return minWay
    }

    private fun pair(i: Int, j: Int): String {
        return "$i;$j"
    }


}
