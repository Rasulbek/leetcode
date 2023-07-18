package leetcode

fun main() {
    val lRUCache = LRUCache(2)
//    println(lRUCache.put(1, 1))
//    println(lRUCache.put(2, 2))
//    println(lRUCache.get(1))
//    println(lRUCache.put(3, 3))
//    println(lRUCache.get(2))
//    println(lRUCache.put(4, 4))
//    println(lRUCache.get(1))
//    println(lRUCache.get(3))
//    println(lRUCache.get(4))
//    println(lRUCache.get(2))
//    println(lRUCache.put(2, 6))
//    println(lRUCache.get(1))
//    println(lRUCache.put(1, 5))
//    println(lRUCache.put(1, 2))
//    println(lRUCache.get(1))
//    println(lRUCache.get(2))
//
//    'write 15th test case from `https://leetcode.com/problems/lru-cache/`'

//    val list = ArrayList<Int>()
//    list.add(1)
//    list.add(2)
//    list.add(3)
//    list.add(4)
//    list.add(5)
//    list.remove(3)
//    list.add(3)
//
//    println(list)

//    return


    val ts = LRUCache(10)
    ts.put(10, 13)
    ts.put(3, 17)
    ts.put(6, 11)
    ts.put(10, 5)
    ts.put(9, 10)
println(ts.get(13))
    ts.put(2, 19)
println(ts.get(2))
println(ts.get(3))
    ts.put(5, 25)
println(ts.get(8))
    ts.put(9, 22)
    ts.put(5, 5)
    ts.put(1, 30)
println(ts.get(11))
    ts.put(9, 12)
println(ts.get(7))
println(ts.get(5))
println(ts.get(8))
println(ts.get(9))
    ts.put(4, 30)
    ts.put(9, 3)
println(ts.get(9))
println(ts.get(10))
println(ts.get(10))
    ts.put(6, 14)
    ts.put(3, 1)
println(ts.get(3))
    ts.put(10, 11)
println(ts.get(8))
    ts.put(2, 14)
println(ts.get(1))
println(ts.get(5))
println(ts.get(4))
    ts.put(11, 4)
    ts.put(12, 24)
    ts.put(5, 18)
println(ts.get(13))
    ts.put(7, 23)
println(ts.get(8))
println(ts.get(12))
    ts.put(3, 27)
    ts.put(2, 12)
println(ts.get(5))
    ts.put(2, 9)
    ts.put(13, 4)
    ts.put(8, 18)
    ts.put(1, 7)
println(ts.get(6))
    ts.put(9, 29)
    ts.put(8, 21)
println(ts.get(5))
    ts.put(6, 30)
    ts.put(1, 12)
println(ts.get(10))
    ts.put(4, 15)
    ts.put(7, 22)
    ts.put(11, 26)
    ts.put(8, 17)
    ts.put(9, 29)
println(ts.get(5))
    ts.put(3, 4)
    ts.put(11, 30)
println(ts.get(12))
    ts.put(4, 29)
println(ts.get(3))
println(ts.get(9))
println(ts.get(6))
    ts.put(3, 4)
println(ts.get(1))
println(ts.get(10))
    ts.put(3, 29)
    ts.put(10, 28)
    ts.put(1, 20)
    ts.put(11, 13)
println(ts.get(3))
    ts.put(3, 12)
    ts.put(3, 8)
    ts.put(10, 9)
    ts.put(3, 26)
println(ts.get(8))
println(ts.get(7))
println(ts.get(5))
    ts.put(13, 17)
    ts.put(2, 27)
    ts.put(11, 15)
println(ts.get(12))
    ts.put(9, 19)
    ts.put(2, 15)
    ts.put(3, 16)
println(ts.get(1))
    ts.put(12, 17)
    ts.put(9, 1)
    ts.put(6, 19)
println(ts.get(4))
println(ts.get(5))
println(ts.get(5))
    ts.put(8, 1)
    ts.put(11, 7)
    ts.put(5, 2)
    ts.put(9, 28)
println(ts.get(1))
    ts.put(2, 2)
    ts.put(7, 4)
    ts.put(4, 22)
    ts.put(7, 24)
    ts.put(9, 26)
    ts.put(13, 28)
    ts.put(11, 26)


}

class LRUCache(capacity: Int) {

    private val cap = capacity
    private val cache = mutableMapOf<Int, Int>()
    private val fifo = ArrayList<Int>()

    fun get(key: Int): Int {
        if (cache.contains(key)) {
            val a = fifo[0]
            fifo.removeAt(0)
            fifo.add(key)
            return cache[key]!!
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            cache[key] = value
            fifo.remove(key)
            fifo.add(key)
            return
        }
        if (cache.size == cap) {
            val a = fifo[0]
            fifo.removeAt(0)
            cache.remove(a)
        }
        fifo.add(key)
        cache[key] = value
    }

}