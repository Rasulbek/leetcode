package leetcode


fun main() {
//    println(ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"))
//    println(ValidPalindrome().isPalindrome("rac"))
//    println(ValidPalindrome().isPalindrome("raar"))
//    println(ValidPalindrome().isPalindrome("rar"))
//    println(ValidPalindrome().isPalindrome("race a car"))
    println(ValidPalindrome().isPalindrome("0P"))
}
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        val t = s.toLowerCase().replace(Regex("[^a-z]"), "")
        if (t.length <= 1) {
            return true
        }

        val l = t.length
        val middle = l / 2
        var i = 0
        while (i <= middle) {
            if (t[i] != t[l-1-i]) {
                return false
            }
            i++
        }
        return true
    }
}