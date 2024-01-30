package leetcode

fun main() {
//    println(MinimumReplacement().minimumReplacement(intArrayOf(19, 7, 2, 24, 11, 16, 1, 11, 23)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(4, 3)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(1, 3)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(3, 9, 3)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(1, 2, 3, 4, 5)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(1, 4, 2, 3)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(5, 2, 4, 3, 1)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(12, 9, 7, 6, 17, 19, 21)))
//    println(MinimumReplacement().minimumReplacement(intArrayOf(7, 6, 15, 6, 11, 14, 10)))
    println(MinimumReplacement().minimumReplacement(intArrayOf(821, 881, 275)))

}

class MinimumReplacement {
    fun minimumReplacement(nums: IntArray): Long {
        if (nums.size == 1) return 0

        var j = nums.size - 2
        var i = nums.size - 1


        while (j >= 0) {
            if (nums[j] > nums[j + 1]) {
                i = j
                break
            }
            j--
        }

        if (j == -1) return 0

        var minResult = 0L

        var ii = i
        var lst = nums[ii + 1]

        while (ii >=0) {
            var bolish = 2
            while ((nums[ii]/bolish) + nums[ii]%bolish  > lst) {
                bolish++
            }
            var birinchi = (nums[ii]/bolish) + nums[ii]%bolish
            while (nums[ii] > lst) {
                nums[ii]-=birinchi
                minResult++
            }
            lst = nums[ii]

            ii--
        }

        return minResult
    }

}