package leetcode

import java.util.Stack
import kotlin.math.max

fun main() {
    println(
        BusRoutes().numBusesToDestination(
            arrayOf(arrayOf(1, 2, 7).toIntArray(), arrayOf(3, 6, 7).toIntArray()),
            1,
            6
        )
    )
    println(
        BusRoutes().numBusesToDestination(
            arrayOf(
                arrayOf(7, 12).toIntArray(),
                arrayOf(4, 5, 15).toIntArray(),
                arrayOf(6).toIntArray(),
                arrayOf(15, 19).toIntArray(),
                arrayOf(9, 12, 13).toIntArray()
            ),
            15,
            12
        )
    )
}

class BusRoutes {


    var enteredStops = Stack<Int>()
    var minWay = Integer.MAX_VALUE
    var target = 0
    val stopsMap = HashMap<Int, Stop>()
    var topildi = false
    var maxroute = 0

    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        this.maxroute = routes.size
        this.target = target
        routes.forEach { route ->
            route.forEach { stop ->
                if (!stopsMap.containsKey(stop)) {
                    stopsMap[stop] = Stop(stop, HashSet())
                }
                route.forEach { otherStop ->
                    if (otherStop != stop) {
                        val stopObject = stopsMap[stop]
                        if (!stopsMap.containsKey(otherStop)) {
                            val otherStopObject = Stop(otherStop, HashSet())
                            stopsMap[otherStop] = otherStopObject
                        }
                        val otherStopObject = stopsMap[otherStop]
                        stopObject!!.canGo.add(otherStopObject!!.stopId)
                        otherStopObject.canGo.add(stopObject.stopId)
                    }
                }
            }
        }


        enteredStops.push(source)
        canReach(stopsMap[source]!!.canGo)

        return if (topildi) minWay else -1
    }

    fun canReach(canGo: HashSet<Int>) {
        if (enteredStops.size > minWay) return
        if (enteredStops.size > this.maxroute) return
        if (canGo.contains(target)) {
//            println("Topildi: $enteredStops")
            topildi = true
            if (enteredStops.size < minWay) minWay = enteredStops.size
        }
        canGo.forEach {
            if (!enteredStops.contains(it)) {
//                val harbirida = stopsMap[enteredStops.peek()]!!.canGo.contains(it)
//                if (!harbirida) {
                    val x = it
                    enteredStops.push(x)
                    canReach(stopsMap[x]!!.canGo)
                    enteredStops.pop()
//                }
            }
        }
    }

    data class Stop(
        var stopId: Int,
        var canGo: HashSet<Int>
    )
}