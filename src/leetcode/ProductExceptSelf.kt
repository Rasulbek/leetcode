package leetcode

fun main() {
    println(productExceptSelf(arrayOf(1,2,3,4).toIntArray()))
    println(productExceptSelf(arrayOf(-1,1,0,-3,3).toIntArray()))
}

fun productExceptSelf(nums: IntArray): IntArray {
    val tepa = IntArray(nums.size)
    val pas = IntArray(nums.size)
    tepa[0] = 1
    pas[nums.size - 1] = 1

    var i = 1
    while (i < nums.size) {
        tepa[i] = tepa[i - 1] * nums[i - 1]
        pas[nums.size - i -1] = pas[nums.size - i] * nums[nums.size - i]
        i++
    }

    i = 0
    val result = IntArray(nums.size)
    println("TEPA: ")
    while (i < tepa.size) {
        result[i] = tepa[i]*pas[i]
        print("${tepa[i]} ")
        i++
    }
    println()
    println("PAS: ")
    i=0
    while (i < pas.size) {
        print("${pas[i]} ")
        i++
    }

    println("RESULT: ")
    i=0
    while (i < result.size) {
        print("${result[i]} ")
        i++
    }

    return IntArray(0)
}