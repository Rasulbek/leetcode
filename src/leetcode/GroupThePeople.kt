package leetcode

fun main() {
    println(GroupThePeople().groupThePeople(arrayOf(3, 3, 3, 3, 3, 1, 3).toIntArray()))
    println(GroupThePeople().groupThePeople(arrayOf(2, 1, 3, 3, 3, 2).toIntArray()))
}

class GroupThePeople {

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val map = HashMap<Int, Int>()
        groupSizes.forEachIndexed { index, value ->
            map[index] = value
        }

        val sortedPairList = map.toList().sortedWith(compareBy { it.second })
        val result = linkedMapOf(*sortedPairList.toTypedArray())

        val javob = ArrayList<List<Int>>()
        var cnt = 0
        var tmp = mutableListOf<Int>()
        result.forEach { key, value ->
            tmp.add(key)
            cnt++
            if (cnt == value) {
                cnt = 0
                val tmp2 = mutableListOf<Int>().apply {
                    addAll(tmp)
                }
                javob.add(tmp2)
                tmp.clear()
            }
        }
        return javob
    }

}