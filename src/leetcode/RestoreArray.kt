package leetcode

fun main() {
    val r = RestoreArray().restoreArray(
        arrayOf(
            arrayOf(4, -2).toIntArray(),
            arrayOf(1, 4).toIntArray(),
            arrayOf(-3, 1).toIntArray()
        )
    )
    r.forEach { print("$it ") }
}

class RestoreArray {
    data class MyPair(
        var left: Int? = null,
        var right: Int? = null
    )

    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val map: HashMap<Int, MyPair> = HashMap()
        adjacentPairs.forEach {
            if (map.containsKey(it[0])) {
                val k = map[it[0]]!!
                k.right = it[1]
            } else {
                map[it[0]] = MyPair(it[1])
            }
            if (map.containsKey(it[1])) {
                val k = map[it[1]]!!
                k.right = it[0]
            } else {
                map[it[1]] = MyPair(it[0])
            }
        }
        var intArray = IntArray(map.size * 2)
        var cIndex = map.size
        var lIndex = map.size
        var rIndex = map.size
        intArray[cIndex] = map.keys.first()
        var lft = map[map.keys.first()]!!.left
        if (lft != null) {
            lIndex--
            intArray[lIndex] = lft
        }
        var rgt = map[map.keys.first()]!!.right
        if (rgt != null) {
            rIndex++
            intArray[rIndex] = rgt
        }
        map.remove(map.keys.first())

        while (true) {
            val x = intArray[rIndex]
            if (!map.containsKey(x)) {
                break
            }
            val a = map[x]!!.left
            val b = map[x]!!.right
            map.remove(x)
            if (a == intArray[rIndex - 1]) {
                if (b != null) {
                    rIndex++
                    intArray[rIndex] = b
                }
            }
            if (b == intArray[rIndex - 1]) {
                if (a != null) {
                    rIndex++
                    intArray[rIndex] = a
                }
            }
        }

//        var oldiTugadimi = false
        while (true) {
            val x = intArray[lIndex]
            if (!map.containsKey(x)) {
                break
            }
            val a = map[x]!!.left
            val b = map[x]!!.right
            map.remove(x)
            if (a == intArray[lIndex + 1]) {
                if (b != null) {
                    lIndex--
                    intArray[lIndex] = b
                }
            }
            if (b == intArray[lIndex + 1]) {
                if (a != null) {
                    lIndex--
                    intArray[lIndex] = a
                }
            }
        }
        val result = IntArray(adjacentPairs.size + 1)
        var c = 0

        for (i in lIndex until rIndex+1) {
            result[c] = intArray[i]
            c++
        }
        return result
    }
}

