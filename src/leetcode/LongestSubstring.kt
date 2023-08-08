package leetcode

fun main() {
    println(LongestSubstring().lengthOfLongestSubstring("abcabcbb"))
    println(LongestSubstring().lengthOfLongestSubstring("bbbbb"))
    println(LongestSubstring().lengthOfLongestSubstring("pwwkew"))
    println(LongestSubstring().lengthOfLongestSubstring(" "))
}

class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        var max = 0
        var ss = ""

        for (i in s.indices) {
            if (ss.contains(s[i])) {
                if (ss.length > max) max = ss.length
                ss = ss.substring(ss.indexOf(s[i])+1)
            }
            ss += s[i]
        }
        if (ss.length > max) max = ss.length

        return max
    }
}