package leetcode

fun main() {
    println(Repetition().repeatedSubstringPattern("abab"))
    println(Repetition().repeatedSubstringPattern("aba"))
    println(Repetition().repeatedSubstringPattern("abcabcabcabc"))
    println(Repetition().repeatedSubstringPattern("abcabcabc"))
    println(Repetition().repeatedSubstringPattern("aa"))
    println(Repetition().repeatedSubstringPattern("aaa"))
}

class Repetition {
    fun repeatedSubstringPattern(s: String): Boolean {
        val prts = HashSet<Int>()
        val l = s.length
        var k: Int = l / 2
        while (k >= 1) {
            if (l % k == 0) {
                prts.add(k)
            }
            k--
        }

        prts.sortedDescending().forEach {
            val bsh = s.substring(0, it)
            var hammasi = true
            var i = 1
            while (i * it < s.length) {
                val prt = s.substring(i*it, (i+1)*it)
                if (prt != bsh) {
                    hammasi = false
                    i++
                    continue
                }
                i++
            }
            if (hammasi) return true
        }

        return false
    }
}