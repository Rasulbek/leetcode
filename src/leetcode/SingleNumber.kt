package leetcode

fun main() {
//    println(singleNumber(arrayOf(2, 2, 3, 2).toIntArray()))
//    println(singleNumber(arrayOf(0, 1, 0, 1, 0, 1, 99).toIntArray()))
    println(hIndex(arrayOf(3, 0, 6, 1, 5).toIntArray()))
    println(hIndex(arrayOf(1, 3, 1).toIntArray()))
    println(hIndex(arrayOf(0).toIntArray()))
    println(hIndex(arrayOf(3, 3, 3, 4).toIntArray()))
    println(hIndex(arrayOf(0, 1, 0, 1, 0, 1, 99).toIntArray()))
    println(hIndex(arrayOf(11,15).toIntArray()))
}

fun hIndex(citations: IntArray): Int {
    citations.sort()
    val sz = citations.size
    if (sz == 1) {
        return if (citations[0] < 1) citations[0] else 1
    }
    var i = 1
    while (i <= sz) {
        if (citations[sz - i] >= i) {
            i++
        } else {
            return i - 1
        }
    }

    return i-1
}

fun singleNumber(nums: IntArray): Int {
    val size = nums.size
    nums.sort()
    var i = 0
    while (i < size) {
        if ((i + 1) > size || (i + 2) > size) {
            return nums[size - 1]
        }
        if (nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
            i += 3
        } else {
            return nums[i]
        }
    }
    return nums[size - 1]
}