package leetcode


fun main() {
    println(ZigZagConversion().convert("PAYPALISHIRING", 3))
    println(ZigZagConversion().convert("PAYPALISHIRING", 4))
    println(ZigZagConversion().convert("A", 1))
}

class ZigZagConversion {

    fun convert(s: String, numRows: Int): String {
        val array = s.toCharArray()
        val result: String
        var matrix = Array(numRows) {
            Array((s.length / 3) + 1) { ' ' }
        }

        matrix[0][0] = array[0]

        var i = 0
        var j = 0
        while (i < result.size) {
            result[i] = array[j]
            j += (numRows - 1) * 2
            j %= result.size
//            j--
            i++
        }

        return result.joinToString("")
    }

}