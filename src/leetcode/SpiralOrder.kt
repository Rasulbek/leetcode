package leetcode

fun main() {
//    println(
//        SpiralOrder().spiralOrder(
//            arrayOf(
//                arrayOf(1, 2, 3).toIntArray(),
//                arrayOf(4, 5, 6).toIntArray(),
//                arrayOf(7, 8, 9).toIntArray()
//            )
//        )
//    )
    println("+============+")
    println(
        SpiralOrder().spiralOrder(
            arrayOf(
                arrayOf(1,2,3,4).toIntArray(),
                arrayOf(5,6,7,8).toIntArray(),
                arrayOf(9,10,11,12).toIntArray(),
//                arrayOf(13,14,15,16).toIntArray(),
            )
        )
    )
}

class SpiralOrder {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = ArrayList<Int>()
        var maxI = matrix.size
        var maxJ = matrix[0].size
        var minI = 0
        var minJ = 0

        var cnt = matrix.size * matrix[0].size
        while (cnt > 0) {
            for (j in minJ until maxJ) {
                result.add(matrix[minI][j])
                cnt--
            }

            for (i in minI+1 until maxI) {
                result.add(matrix[i][maxJ-1])
                cnt--
            }

            minI++
            maxJ--

            var j = maxJ -1
            while (j >= minJ && cnt>0) {
                result.add(matrix[maxI-1][j])
                j--
                cnt--
            }

            maxI--

            var i = maxI - 1
            while (i >= minI && cnt>0) {
                result.add(matrix[i][minJ])
                i--
                cnt--
            }

            minJ++

        }

        return result
    }
}