package leetcode

fun main() {
    println(
        MaximalNetworkRank().maximalNetworkRank(
            4, arrayOf(
                arrayOf(0, 1).toIntArray(),
                arrayOf(0, 3).toIntArray(),
                arrayOf(1, 2).toIntArray(),
                arrayOf(1, 3).toIntArray(),
            )
        )
    )
    println(
        MaximalNetworkRank().maximalNetworkRank(
            5, arrayOf(
                arrayOf(0, 1).toIntArray(),
                arrayOf(0, 3).toIntArray(),
                arrayOf(1, 2).toIntArray(),
                arrayOf(1, 3).toIntArray(),
                arrayOf(2, 3).toIntArray(),
                arrayOf(2, 4).toIntArray(),
            )
        )
    )
    println(
        MaximalNetworkRank().maximalNetworkRank(
            8, arrayOf(
                arrayOf(0, 1).toIntArray(),
                arrayOf(1, 2).toIntArray(),
                arrayOf(2, 3).toIntArray(),
                arrayOf(2, 4).toIntArray(),
                arrayOf(5, 6).toIntArray(),
                arrayOf(5, 7).toIntArray(),
            )
        )
    )
}

class MaximalNetworkRank {

    lateinit var summas: IntArray
    lateinit var arr: Array<IntArray>
    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        summas = IntArray(n) { 0 }
        arr = Array(n) { IntArray(n) { 0 } }
        for (i in roads.indices) {
                arr[roads[i][0]][roads[i][1]] = 1
                arr[roads[i][1]][roads[i][0]] = 1
                summas[roads[i][0]]++
                summas[roads[i][1]]++
        }
        var max = 0
        var i = 0
        while (i < summas.size - 1) {
            var j = i + 1
            while (j < summas.size) {
                var tmp = summas[i] + summas[j] - arr[i][j]
                if (tmp > max) max= tmp
                j++
            }
            i++
        }

        return max
    }
}