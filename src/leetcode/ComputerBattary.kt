package leetcode


fun main() {
    println(ComputerBattery().maxRunTime(2, arrayOf(3,3,3).toIntArray()))
    println(ComputerBattery().maxRunTime(2, arrayOf(1,1,1,1).toIntArray()))
}
class ComputerBattery {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        var life = 0L
        if (batteries.size < n) {
            return 0
        }
        var sorted = batteries.sortedDescending().toMutableList()

        while (n < sorted.size) {
            for (i in 0 until n) {
                if (sorted[i]==0) {
                    return life
                }
                sorted[i] -= 1
            }
            var idx = 0
            for (i in 0 until n) {
                if (sorted[idx]==0) {
                    sorted.removeAt(idx)
                } else {
                    idx++
                }
            }
            life++
//            sorted = sorted.sortedDescending().toMutableList()
        }
        return life
    }
}