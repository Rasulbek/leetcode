package leetcode

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet


fun main() {
//    println(CanFinish().canFinish(2, arrayOf(intArrayOf(1, 0))))
//    println(CanFinish().canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
//    println(CanFinish().canFinish(3, arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(0, 1))))
    println(CanFinish().canFinish(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1,2))))
}

class CanFinish {

    private val stack: HashSet<Int> = HashSet()
    private val finishables = HashSet<Int>()
    private val littleFinishables = HashSet<Int>()
    class Subject(val id: Int) {
        var dependants = HashSet<Subject>()
    }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val arrayOfSubs = ArrayList<Subject>()
        for (i in 0 until numCourses) {
            arrayOfSubs.add(i, Subject(i))
        }
        for (i in prerequisites) {
            arrayOfSubs[i[0]].dependants.add(arrayOfSubs[i[1]])
        }

        for (s in arrayOfSubs) {
            if (!can(s)) {
                return false
            }
        }

        return true
    }

    private fun can(subject: Subject): Boolean {
        if (subject.dependants.isEmpty()) {
            finishables.addAll(littleFinishables)
            littleFinishables.clear()
            finishables.add(subject.id)
            return true
        }
        if (finishables.contains(subject.id)) {
            finishables.addAll(littleFinishables)
            littleFinishables.clear()
            return true
        }

        for (d in subject.dependants) {
            if (stack.contains(d.id)) {
                return false
            }
            littleFinishables.add(d.id)
            stack.add(d.id)
            val tmp = can(d)
            stack.remove(d.id)
            if (!tmp) {
                return false
            }
        }
        return true
    }


    //48th test time limit
}