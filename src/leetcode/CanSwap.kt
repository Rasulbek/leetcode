package leetcode

fun main() {

    println(buddyStrings("ab", "ba"))
    println(buddyStrings("ab", "ab"))
    println(buddyStrings("aa", "aa"))
    println(buddyStrings("abcd", "cbad"))
    println(buddyStrings("abcd", "bcda"))
    println(buddyStrings("abcaa", "abcbb"))


}
fun buddyStrings(s: String, goal: String): Boolean {
    if (s.length != goal.length) {
        return false
    }
    var i = 0
    val sMap = HashMap<Char, Int>()
    val gMap = HashMap<Char, Int>()
    var first = false
    var second = false
    var s1: Char = '*'
    var g1: Char = '/'
    var s2: Char = '+'
    var g2: Char = '-'
    while (i < s.length) {
        if (sMap[s[i]] == null) {
            sMap[s[i]] = 1
        } else {
            sMap[s[i]] = sMap[s[i]]!! + 1
        }

        if (gMap[goal[i]] == null) {
            gMap[goal[i]] = 1
        } else {
            gMap[goal[i]] = gMap[goal[i]]!! + 1
        }

        if (!first && s[i] != goal[i]) {
            s1 = s[i]
            g1 = goal[i]
            first = true
        } else if (first && !second && s[i] !=goal[i]) {
            second = true
            s2 = s[i]
            g2=goal[i]
        } else if (first && second && s[i] !=goal[i]) {
            return false
        }
        i++
    }

    if (!first) {
        sMap.filter { it.value >= 2 }.forEach {
            if (gMap[it.key]!! >= 2) {
                return true
            }
        }
        return false
    } else return second && s1 == g2 && s2 == g1
}