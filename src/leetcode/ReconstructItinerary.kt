package leetcode

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(
        ReconstructItinerary().findItinerary(
            listOf(
                listOf("MUC", "LHR"),
                listOf("JFK", "MUC"),
                listOf("SFO", "SJC"),
                listOf("LHR", "SFO")
            )
        )
    )
    println(
        ReconstructItinerary().findItinerary(
            listOf(
                listOf("JFK", "SFO"),
                listOf("JFK", "ATL"),
                listOf("SFO", "ATL"),
                listOf("ATL", "JFK"),
                listOf("ATL", "SFO")
            )
        )
    )
    println(
        ReconstructItinerary().findItinerary(
            listOf(
                listOf("JFK", "C"),
                listOf("C", "JFK"),
                listOf("JFK", "B")
            )
        )
    )
}

class ReconstructItinerary {
    val result = ArrayList<String>().apply { add("JFK") }
    var size = 0
    val map = HashMap<String, ArrayList<String>>()

    fun findItinerary(tickets: List<List<String>>): List<String> {
        size = tickets.size + 1
        tickets.sortedBy { it[1] }.forEach {
            if (!map.contains(it[0])) {
                map[it[0]] = ArrayList()
            }
            map[it[0]]!!.add(it[1])
        }
        dfs("JFK")
        return result
    }

    fun dfs(src: String): Boolean {
        if (result.size == size) return true

        if (!map.contains(src)) return false

        val tmp = mutableListOf<String>().apply {
            addAll(map[src]!!)
        }
        tmp.forEachIndexed { index, s ->
            result.add(s)
            map[src]!!.removeAt(index)
            if (dfs(s)) return true
            map[src]!!.add(index, s)
            result.removeLast()
        }
        return false
    }


}