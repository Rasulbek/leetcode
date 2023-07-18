package leetcode

fun main() {
//    val case2 = arrayOf(2,3,1,1,4).toIntArray()
//    println(canJump(case1))
//    val case2 = arrayOf(3,2,1,0,4).toIntArray()
    val case2 = arrayOf(1,1,1,0).toIntArray()
    println(canJump(case2))
}

fun canJump(nums: IntArray): Int {
    val arraySize = nums.size
    val jumpCounts = IntArray(nums.size) { -1 }

    var i = nums.size - 1
    while (i >= 0) {
        if (i == arraySize - 1) {
            jumpCounts[i] = 0
        } else if (nums[i] == 0) {
            jumpCounts[i] = -1
        } else {
            var j = i
            var tmpMin = 10001
            val lst = if (i + nums[i] >= arraySize) {
                arraySize - 1
            } else {
                i + nums[i]
            }
            while (j <= lst) {
                if (jumpCounts[j] > -1 && tmpMin > jumpCounts[j]) {
                    tmpMin = jumpCounts[j]
                }
                j++
            }
            jumpCounts[i] = tmpMin + 1
        }
        i--
    }

    for (k in jumpCounts.indices) {
        print("${jumpCounts[k]} ")
    }

    return jumpCounts[0]
}


