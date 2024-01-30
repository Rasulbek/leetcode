package leetcode

fun main() {
    println(Combinations().combine(4, 2))
    println(Combinations().combine(1, 1))
}

class Combinations {

    
    fun combine(n: Int, k: Int): List<List<Int>> {
        val arr = IntArray(n + 1)
        for (i in 0 until n + 1) {
            arr[i] = i
        }
        return emptyList()
    }


}