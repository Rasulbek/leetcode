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
}