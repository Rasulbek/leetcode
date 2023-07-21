package leetcode


fun main() {

    var nums = arrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    nums = arrayOf(0,1,0,3,2,3)
    nums = arrayOf(7,7,7,7,7,7,7)
    println(LongestIncreasingSequence().lengthOfLIS(nums.toIntArray()))

}

class LongestIncreasingSequence {

    fun lengthOfLIS(nums: IntArray): Int {
        val array = IntArray(nums.size) { 1 }
        var max = 1

        val l = nums.size
        var i = nums.size - 2

        while (i >= 0) {
            var tmpMax = 0
            for (k in i + 1 until l) {
                if (nums[k] > nums[i] && array[k] > tmpMax) {
                    tmpMax = array[k]
                }
            }
            array[i] += tmpMax
            tmpMax = array[i]
            if (tmpMax > max) {
                max = tmpMax
            }
            i--
        }

        return max
    }

}