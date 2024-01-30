package leetcode

fun main() {
    println(
        ArithmeticSubarray().checkArithmeticSubarrays(
            intArrayOf(4, 6, 5, 9, 3, 7),
            intArrayOf(0, 0, 2),
            intArrayOf(2, 3, 5)
        )
    )
    println(
        ArithmeticSubarray().checkArithmeticSubarrays(
            intArrayOf(-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10),
            intArrayOf(0, 1, 6, 4, 8, 7),
            intArrayOf(4, 4, 9, 7, 9, 10)
        )
    )
}

class ArithmeticSubarray {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): List<Boolean> {
        var i = 0
        val result = mutableListOf<Boolean>()
        while (i < l.size) {
            val len = r[i] - l[i] + 1
            val subarray = IntArray(len)
            System.arraycopy(nums, l[i], subarray, 0, len)
            result.add(isArithmetic(subarray))
            i++
        }
        return result
    }


    private fun isArithmetic(array: IntArray): Boolean {
        if (array.size < 2) return true
        array.sort()
        val sub = array[1] - array[0]
        var i = 2
        while (i < array.size) {
            if (array[i] - array[i - 1] != sub) return false
            i++
        }
        return true
    }
}