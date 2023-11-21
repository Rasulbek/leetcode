package leetcode

import kotlin.math.pow

fun main() {
//    println(NicePairsCount().countNicePairs(intArrayOf(42,11,1,97)))
    println(NicePairsCount().countNicePairs(intArrayOf(42,11,1,97,100,102)))
//    println(NicePairsCount().countNicePairs(intArrayOf(13, 10, 35, 24, 76)))
}

class NicePairsCount {
    private val cMap = HashMap<Int,Int>()
    fun countNicePairs(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        var i = 0
        var tmp = 0
        nums.forEach { _ ->
            tmp = nums[i] - rev(nums[i])
            if (map.contains(tmp)) {
                map[tmp] = map[tmp]!!+1
            }else {
                map[tmp]=1
            }
            i++
        }
        var c = 0

        map.forEach {
            c+=calculate(it.value)
        }

        return c % (10.0.pow(9.0) + 7).toInt()
    }

    private fun calculate(k: Int): Int {
        return if (cMap.contains(k)) {
            cMap[k]!!
        } else {
            var s = 0
            for (i in 0 until k) {
                s+=i
            }
            cMap[k] = s
            s
        }
    }

    private fun rev(x: Int): Int {
        var r = 0
        var s = x
        while (s > 0) {
            r *= 10
            r += s % 10
            s /= 10
        }
        return r
    }
}