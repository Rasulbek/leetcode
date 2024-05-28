package leetcode

import java.util.LinkedList
import kotlin.math.abs

fun main() {
    println(SubstringWithinBudget().equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14))
    println(SubstringWithinBudget().equalSubstring("abcd", "bcdf", 3))
    println(SubstringWithinBudget().equalSubstring("abcd", "cdef", 3))
    println(SubstringWithinBudget().equalSubstring("abcd", "acde", 0))
}

class SubstringWithinBudget {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        val subs = mutableListOf<Int>()
        val l = s.length
        var i = 0
        while (i < l) {
            subs.add(abs(s[i] - t[i]))
            i++
        }
        var maxL = 0
        val linkedList= LinkedList<Int>()
        i = 0
        var sum = 0
        while (i < l) {
            linkedList.add(subs[i])
            sum += subs[i]
            while (sum > maxCost) {
                sum -= linkedList.poll()
            }
            maxL = maxOf(maxL, linkedList.size)
            i++
        }

        return maxL
    }
}