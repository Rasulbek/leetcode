package leetcode

fun main() {
//    DiagonalTraverse2().findDiagonalOrder(listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)))
//        .forEach { print("$it, ") }
//    println()
//    DiagonalTraverse2().findDiagonalOrder(
//        listOf(
//            listOf(1, 2, 3, 4, 5),
//            listOf(6, 7),
//            listOf(8),
//            listOf(9, 10, 11),
//            listOf(12, 13, 14, 15, 16)
//        )
//    ).forEach { print("$it, ") }
//    println()
//
//    DiagonalTraverse2().findDiagonalOrder(
//        listOf(
//            listOf(1, 2, 3),
//            listOf(4),
//            listOf(5, 6, 7),
//            listOf(8),
//            listOf(9, 10, 11)
//        )
//    ).forEach { print("$it, ") }
    DiagonalTraverse2().findDiagonalOrder(
        listOf(
            listOf(1),
            listOf(2),
            listOf(3,3,4),
            listOf(4),
            listOf(5),
            listOf(6)
        )
    ).forEach { print("$it, ") }
}

class DiagonalTraverse2 {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        if (nums.size == 1) {
            return nums[0].toIntArray()
        }
        val result = ArrayList<Int>()
        if (nums.maxOf{it.size} == 1) {
            nums.forEach {ix ->
                ix.forEach {
                    result.add(it)
                }
            }
            return result.toIntArray()
        }
        val maxL = Math.max(nums.size, nums.maxOf{ it.size })
        var i = 0
        var j = 0

        while (i < maxL) {
            var ii = i
            var jj = 0
            while (ii >= 0) {
                if (nums.size >=ii
                    && nums[ii].size >jj) {
                    print("${nums[ii][jj]}, ")
                    result.add(nums[ii][jj])
                }
                jj++
                ii--
            }
            i++
        }

        j = 1
        while (j < maxL) {
            i = maxL - 1
            var jj = j
            while (jj<maxL) {
                if (nums.size >=i && nums[i].size>jj) {
                    print("${nums[i][jj]}, ")

                    result.add(nums[i][jj])
                }
                i--
                jj++
            }
            j++
        }
        return result.filter { it != 0 }.toIntArray()
    }
}