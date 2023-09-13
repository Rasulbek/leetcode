package leetcode

fun main() {
    println(Dota2Senate().predictPartyVictory("DRRDRDRDRDDRDRDRD"))
    println(Dota2Senate().predictPartyVictory("DRRD"))
    println(Dota2Senate().predictPartyVictory("DRDRR"))
    println(Dota2Senate().predictPartyVictory("RD"))
    println(Dota2Senate().predictPartyVictory("RDD"))
    println(Dota2Senate().predictPartyVictory("R"))
    println(Dota2Senate().predictPartyVictory("D"))
    println(Dota2Senate().predictPartyVictory("RDRDRDRDDDDD"))
}

class Dota2Senate {

    fun predictPartyVictory(senate: String): String {
        val s = mutableListOf<Char>()
        senate.forEach {
            s.add(it)
        }

        var b = true
        var i = 0
        var winner = ""
        while (b) {
            val opponent = if (s[i] == 'R') {
                winner = "Radiant"
                'D'
            } else {
                winner = "Dire"
                'R'
            }
            if (s.contains(opponent)) {
                var firstAfterIndex = -1
                s.forEachIndexed { index, c ->
                    if (firstAfterIndex == -1 && index > i && c == opponent) firstAfterIndex = index
                }
                if (firstAfterIndex > -1) {
                    s.removeAt(firstAfterIndex)
                } else {
                    s.stream().filter { c -> c == opponent }.findFirst().ifPresent(s::remove)
                }
            } else {
                return winner
            }
            i++
            if (i >= s.size) {
                i = 0
            }
            if (s.size == 1) {
                b = false
            }
        }

        return winner
    }

}