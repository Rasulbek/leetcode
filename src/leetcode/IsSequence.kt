package leetcode


fun main() {
    println(IsSequence().isSubsequence("abc", "ahbgdc"))
    println(IsSequence().isSubsequence("axc", "ahbgdc"))
    println(IsSequence().isSubsequence("cabd", "b"))
}
class IsSequence {

    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        var c = 0
        val sl = s.length
        val tl = t.length

        while (i < sl && j < tl) {
            if (s[i] ==t[j]) {
                c++
                i++
            }
            j++
        }
        return c == s.length
    }

}