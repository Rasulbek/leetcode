package leetcode


fun main() {
    println(ReductionOpCount().reductionOperations(intArrayOf(5,1,3)))
    println(ReductionOpCount().reductionOperations(intArrayOf(1,1,1)))
    println(ReductionOpCount().reductionOperations(intArrayOf(1,1,2,2,3)))
    println(ReductionOpCount().reductionOperations(intArrayOf(1, 1, 2, 2, 3, 3, 3, 3)))
}

class ReductionOpCount {
    fun reductionOperations(nums: IntArray): Int {
        nums.sort()
        val cnt = IntArray(nums.size) { -1 }
        var i = nums.size - 1
        while (i >= 0) {
            var j = i
            do {
                cnt[j]++
                j--
            } while (j >= 0 && nums[j] == nums[i])
            if (j>=0) {
                var x = j + 1
                while (x < cnt.size) {
                    cnt[x]++
                    x++
                }
            }

            i = j
        }
        var sum = 0
        var x = 0
        while (x < cnt.size) {
            sum += cnt[x]
            x++
        }
        return sum
    }
}