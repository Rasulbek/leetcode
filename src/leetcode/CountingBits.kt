package leetcode


fun main() {
    println(CountingBits().countBits(2))
    println(CountingBits().countBits(5))
    println(CountingBits().countBits(10))
}
class CountingBits {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n+1)
        for (i in 0 until n+1) {
            result[i]=Integer.bitCount(i)
        }
        return result
    }
}