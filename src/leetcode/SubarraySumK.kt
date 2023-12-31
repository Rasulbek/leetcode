package leetcode

class SubarraySumK {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        map[0] = 1
        var subSum = 0
        var numToSubtract = 0
        var answer = 0
        var i = 0
        while(i < nums.size) {
            subSum += nums[i]
            numToSubtract = subSum - k
            answer += map.getOrDefault(numToSubtract, 0)
            map[subSum] = map.getOrDefault(subSum, 0) + 1
            i++
        }
        return answer
    }

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        nums.sortDescending()
        var tmp = 0
        var i = 0
        var j = 0
        var cnt = 0
        var found = false
        var min = nums.size
        while (j < nums.size) {
            i = j
            tmp=0
            cnt = 0
            while (i < nums.size) {
                tmp += nums[i]
                cnt++
                if (tmp >= target) {
                    found = true
                    if (cnt < min) min = cnt
                    break
                }
                i++
            }
            j++
        }

        return if (found) min else 0
    }
}