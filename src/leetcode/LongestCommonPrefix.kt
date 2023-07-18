package leetcode

fun main() {
//    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
//    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("dog", "racecar", "car")))
//    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("car", "cir")))
    println(LongestCommonPrefix().reverseWords("the sky is blue"))
    println(LongestCommonPrefix().reverseWords("  hello world  "))
    println(LongestCommonPrefix().reverseWords("a good   example"))
}

class LongestCommonPrefix {

    fun reverseWords(s: String): String {
        var t = s.trim()
        var result = ""
        var fx: Int
        while (t.isNotEmpty()) {
            fx = t.indexOfFirst { it == ' ' }
            val last = if (fx == -1) {
                t.length
            } else {
                fx
            }
            result = t.substring(0, last) + " " + result
            t = t.substring(last).trim()
        }
        return result.trim()
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        var idx = 0
        var minL = strs[idx].length
        for (i in strs.indices) {
            if (minL > strs[i].length) {
                idx = i
                minL = strs[i].length
            }
        }

        var javob = ""
        val lastIndex = strs[idx].length

        for (j in 0 until lastIndex + 1) {
//            for (k in j + 1 until lastIndex + 1) {
            var has = true
            val substr = strs[idx].substring(0, j)
            for (i in strs.indices) {
                if (!strs[i].startsWith(substr)) {
                    has = false
                    break
                }
            }
            if (has && (j + 1) > javob.length) {
                javob = strs[idx].substring(0, j)
            }
//            }
        }
        return javob
    }
}
