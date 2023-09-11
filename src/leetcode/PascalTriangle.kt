package leetcode


fun main() {
    println(PascalTriangle().generate(2))
    println(PascalTriangle().generate(5))
    println(PascalTriangle().generate(1))
}

class PascalTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf(List(1) { 1 })
        if (numRows == 1) {
            return result
        }
        var i = 1
        while (i < numRows) {
            val l = IntArray(i + 1) { 1 }
            var j = 1
            while (j < i) {
                l[j] = result[i - 1][j - 1] + result[i - 1][j]
                j++
            }
            result.add(l.toList())
            i++
        }
        return result
    }
}