package leetcode

fun main() {
    println(GroupThePeople().groupThePeople(arrayOf(3, 3, 3, 3, 3, 1, 3).toIntArray()))
    println(GroupThePeople().groupThePeople(arrayOf(2, 1, 3, 3, 3, 2).toIntArray()))
}

class GroupThePeople {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {

        val array = hashMapOf<Int, MutableList<Int>>()
        val javob = ArrayList<List<Int>>()

        groupSizes.forEachIndexed { index, i ->
            if (array[i] == null) {
                array[i] = mutableListOf<Int>().apply { add(index) }
                if (i == 1) {
                    javob.add(array[i]!!.toList())
                    array[i]!!.clear()
                }
                return@forEachIndexed
            }
            array[i]!!.add(index)


            if (array[i]!!.size == i) {
                javob.add(array[i]!!.toList())
                array[i]!!.clear()
            }
        }

        return javob
    }

//    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
//        val map = HashMap<Int, Int>()
//        groupSizes.forEachIndexed { index, value ->
//            map[index] = value
//        }
//
//        val sortedPairList = map.toList().sortedWith(compareBy { it.second })
//        val result = linkedMapOf(*sortedPairList.toTypedArray())
//
//        val javob = ArrayList<List<Int>>()
//        var cnt = 0
//        var tmp = mutableListOf<Int>()
//        result.forEach { key, value ->
//            tmp.add(key)
//            cnt++
//            if (cnt == value) {
//                cnt = 0
//                val tmp2 = mutableListOf<Int>().apply {
//                    addAll(tmp)
//                }
//                javob.add(tmp2)
//                tmp.clear()
//            }
//        }
//        return javob
//    }

}