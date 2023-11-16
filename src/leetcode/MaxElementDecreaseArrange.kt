package leetcode

fun main() {
    println(MaxElementDecreaseArrange().maximumElementAfterDecrementingAndRearranging(intArrayOf(2,2,1,2,1)))
    println(MaxElementDecreaseArrange().maximumElementAfterDecrementingAndRearranging(intArrayOf(100,1,1000)))
    println(MaxElementDecreaseArrange().maximumElementAfterDecrementingAndRearranging(intArrayOf(1,2,3,4,5)))
}

class MaxElementDecreaseArrange {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        arr[0] = 1
        var c = 1
        arr.forEach {
            if (it > c) {
                c++
            }
        }
        return c
    }
}