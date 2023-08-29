package leetcode

fun main() {
    println(MinimumPenalty().bestClosingTime("YYNY"))
    println(MinimumPenalty().bestClosingTime("YN"))
    println(MinimumPenalty().bestClosingTime("NNNN"))
    println(MinimumPenalty().bestClosingTime("YYYY"))
    println(MinimumPenalty().bestClosingTime("YYNYYYNY"))
    println(MinimumPenalty().bestClosingTime("YYNYYYNYY"))
    println(MinimumPenalty().bestClosingTime("NNYYY"))
}
class MinimumPenalty {

    fun bestClosingTime(customers: String): Int {
        var tmp = 0
        var max = 0
        var mi = 0
        customers.forEachIndexed { i, c ->
            if (c=='Y') {
                tmp++
                if (tmp > max) {
                    max = tmp
                    mi = i+1
                }
            } else {
                tmp--
            }
        }

        return mi
    }
}