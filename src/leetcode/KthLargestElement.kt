package leetcode

fun main() {
    println(KthLargestElement().findKthLargest(arrayOf(3,2,1,5,6,4).toIntArray(), 2))
    println(KthLargestElement().findKthLargest(arrayOf(3,2,3,1,2,4,5,5,6).toIntArray(), 4))
    println(KthLargestElement().findKthLargest(arrayOf(-1, -1).toIntArray(), 2))
}

class KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val arr = IntArray(20001) { 0 }
        for (i in nums.indices) {
            arr[nums[i] + 10000]++
        }
        var kk = k
        var i = 20000
        while (kk > 0) {
            kk -= arr[i]
            i--
        }
        return i - 9999
    }
}