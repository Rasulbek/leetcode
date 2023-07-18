package leetcode

class RandomizeSet {
    val set = HashSet<Int>()
    fun insert(`val`: Int): Boolean {
        val sz = set.size
        set.add(`val`)
        return sz == set.size
    }

    fun remove(`val`: Int): Boolean {
        val sz = set.size
        set.remove(`val`)
        return sz == set.size
    }

    fun getRandom(): Int {
        return set.random()
    }

}