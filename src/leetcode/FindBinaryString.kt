package leetcode

fun main() {
    println(FindBinaryString().findDifferentBinaryString(arrayOf("01", "10")))
    println(FindBinaryString().findDifferentBinaryString(arrayOf("00", "01")))
    println(FindBinaryString().findDifferentBinaryString(arrayOf("111", "011", "001")))
}
class FindBinaryString {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val set = HashSet<Int>()
        nums.forEach {
            set.add(it.toInt(2))
        }
        var i = 0
        while (set.contains(i)) {
            i++
        }
        return Integer.toBinaryString(i).padStart(nums.size, '0')
    }
}