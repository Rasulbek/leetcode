package leetcode


fun main() {
    println(TwoSum().twoSum(arrayOf(2,7,11,15).toIntArray(), 9))
    println(TwoSum().twoSum(arrayOf(2,3,4).toIntArray(), 6))
    println(TwoSum().twoSum(arrayOf(-1,0).toIntArray(), -1))
}

class TwoSum {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val hm = HashMap<Int, Int>()
        var st = 0
        for (i in numbers.indices) {
            st = target - numbers[i]
            if (hm.contains(st)) {
                return arrayOf(hm[st]!! + 1, i + 1).toIntArray()
            }
            hm[numbers[i]] = i
        }
        return arrayOf(1,2).toIntArray()
    }
}