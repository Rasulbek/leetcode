package leetcode

fun main() {
//    println(RomanDigits().romanToInt("III"))
//    println(RomanDigits().romanToInt("LVIII"))
//    println(RomanDigits().romanToInt("MCMXCIV"))

    println(RomanDigits().intToRoman(1994))
}

class RomanDigits {
    fun romanToInt(s: String): Int {
        val digits = IntArray(s.length)
        var i = 0
        var current: Int
        while (i < s.length) {
            current = romanToInt(s[i])
            if (digits[i] == current) {
                digits[i] = digits[i] + current
            } else {
                digits[i] = current
                i++
            }
        }
        i--
        var result = digits[i]
        i--
        while (i >= 0) {
            if (digits[i] < digits[i+1]) {
                result -= digits[i]
            } else {
                result += digits[i]
            }
            i--
        }
        return result
    }

    private fun romanToInt(c: Char): Int {
        return when(c) {
            'M' -> 1000
            'D' -> 500
            'C' -> 100
            'L' -> 50
            'X' -> 10
            'V' -> 5
            'I' -> 1
            else -> {0}
        }
    }

    fun intToRoman(num: Int): String {
        var multiplier = 1
        var num2 = num
        val array = IntArray(4)
        var i = 0
        while (num2 > 0) {
            array[i] = (num2 % 10) * multiplier
            num2 /= 10
            multiplier *= 10
            i++
        }

        var result = ""
        while (i > 0) {
            result+=digitToRoman(array[i-1])
            i--
        }

        return result
    }

    fun digitToRoman(num: Int): String {
        return when(num) {
            3000 -> "MMM"
            2000 -> "MM"
            1000 -> "M"
            900 -> "CM"
            800 -> "DCCC"
            700 -> "DCC"
            600 -> "DC"
            500 -> "D"
            400 -> "CD"
            300 -> "CCC"
            200 -> "CC"
            100 -> "C"
            90 -> "XC"
            80 -> "LXXX"
            70 -> "LXX"
            60 -> "LX"
            50 -> "L"
            40 -> "XL"
            30 -> "XXX"
            20 -> "XX"
            10 -> "X"
            9 -> "IX"
            8 -> "VIII"
            7 -> "VII"
            6 -> "VI"
            5 -> "V"
            4 -> "IV"
            3 -> "III"
            2 -> "II"
            1 -> "I"

            else -> ""
        }
    }

}