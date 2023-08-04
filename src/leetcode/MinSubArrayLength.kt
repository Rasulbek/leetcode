package leetcode

import java.util.Stack
import kotlin.math.min


fun main() {
//    println(MinSubArrayLength().minSubArrayLen(7, arrayOf(2, 3, 1, 2, 4, 3).toIntArray()))
//    println(MinSubArrayLength().minSubArrayLen(4, arrayOf(1, 4, 4).toIntArray()))
//    println(MinSubArrayLength().minSubArrayLen(11, arrayOf(1, 1, 1, 1, 1, 1, 1, 1).toIntArray()))
    println(MinSubArrayLength().minSubArrayLen(11, arrayOf(1, 2, 3, 4, 5).toIntArray()))

}

class MinSubArrayLength {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val numStack = Stack<Int>()
        val indexStack = Stack<Int>()
        nums.sortDescending()
        var tmp = 0
        var i = 0
        var j = 0
        while (j < nums.size) {
            i = j
            tmp=0
            while (i < nums.size) {
                numStack.add(nums[i])
                indexStack.add(i)
                tmp += nums[i]
                if (tmp >= target) {
                    return numStack.size
                } else if (tmp > target) {
                    tmp-=numStack.pop()
                    indexStack.pop()
                }
                i++
            }
            j++
        }


        return 0
    }
}