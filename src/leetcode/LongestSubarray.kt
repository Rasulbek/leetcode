package leetcode

fun main() {
//    println(longestSubarray(arrayOf(1, 1, 0, 1).toIntArray()))
//    println(longestSubarray(arrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1).toIntArray()))
//    println(longestSubarray(arrayOf(1, 1, 1).toIntArray()))
//    println(longestSubarray(arrayOf(1).toIntArray()))
//    println(longestSubarray(arrayOf(1,0,1,1,1,1,1,1,0,1,1,1,1,1).toIntArray()))
    println(lengthOfLastWord("Hello World"))
    println(lengthOfLastWord("   fly me   to   the moon  "))
    println(lengthOfLastWord("luffy is still joyboy"))
}

fun lengthOfLastWord(s: String): Int {
    var firstNonSpaceMet = false
    val l = s.length
    var i = l - 1
    var count = 0
    while (i >= 0) {
        if (s[i] == ' ') {
            if (firstNonSpaceMet) {
                return count
            }
        } else {
            firstNonSpaceMet = true
            count++
        }
        i--
    }
    return count
}

fun longestSubarray(nums: IntArray): Int {

    var max = 0
    var firstZero = false
    var secondZero = false
    var first = 0
    var second = 0

    var i = 0
    while (i < nums.size) {
        if (nums[i] == 0) {
            if (!firstZero) {
                if (first > 0) {
                    firstZero = true
                }
            } else {
                secondZero = true
            }
            if (secondZero) {
                if (first + second > max) {
                    max = first + second
                }

                firstZero = false
                secondZero = false
                first = 0

                if ((i + 1 < nums.size) && nums[i+1] == 1) {
                    firstZero = true
                    first = second
                }

                second = 0
            }
        } else {
            if (firstZero) {
                second++
            } else {
                first++
            }
        }
        i++
    }
    if (first + second > max) {
        max = first + second
    }
    if (max == nums.size) {
        max--
    }
    return max
}