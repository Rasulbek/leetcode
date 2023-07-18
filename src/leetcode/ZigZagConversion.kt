package leetcode


fun main() {
//    println(ZigZagConversion().convert("PAYPALISHIRING", 3))
//    println(ZigZagConversion().convert("PAYPALISHIRING", 4))
//    println(ZigZagConversion().convert("A", 1))
    println(ZigZagConversion().strStr("asaadbutsad", "sad"))
}

class ZigZagConversion {

    fun strStr(haystack: String, needle: String): Int {
        var i = 0
        val l = needle.length
        if (l > haystack.length) {
            return -1
        }
        while (i <= haystack.length - l) {
            if (haystack.substring(i, i+l) == needle) {
                return i
            }
            i++
        }
        return -1
    }

    fun convert(s: String, numRows: Int): String {
        val array = s.toCharArray()
        var result: String = ""
        var matrix = Array(numRows) {
            Array(s.length) { ' ' }
        }

        matrix[0][0] = array[0]

        var i = 0
        var j = 0
        var c = 0
        var pastga = true
        var tepaga = false
        while (c < array.size) {
            matrix[i][j] = array[c]
            if (pastga) {
                i++
            }
            if (tepaga) {
                i--
                j++
            }
            if (i == numRows - 1) {
                tepaga = true
                pastga = false
            }
            if (i == 0) {
                tepaga = false
                pastga = true
            }
            c++
        }

        for (i in 0 until numRows) {
            for(j in s.indices) {
                if (matrix[i][j] != ' ') result += matrix[i][j]
            }
        }

        return result.replace(" ", "")
    }

}