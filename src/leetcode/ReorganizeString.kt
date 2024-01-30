package leetcode

fun main() {
//    println(ReorganizeString().reorganizeString("baaba"))
//    println(ReorganizeString().reorganizeString("abbbabaaa"))
//    println(ReorganizeString().reorganizeString("a"))
//    println(ReorganizeString().reorganizeString("ab"))
//    println(ReorganizeString().reorganizeString("aa"))
//    println(ReorganizeString().reorganizeString("baaab"))
//    println(ReorganizeString().reorganizeString("baabb"))
//    println(ReorganizeString().reorganizeString("aaabb"))
//    println(ReorganizeString().reorganizeString("aab"))
//    println(ReorganizeString().reorganizeString("aaab"))
//    println(ReorganizeString().reorganizeString("aaabbcdd"))
    println(ReorganizeString().reorganizeString("abbabbaaab"))
//    println(ReorganizeString().reorganizeString("acbbbbddddd"))
}

class ReorganizeString {

    fun reorganizeString(s: String): String {

        if (s.length == 1) return s

        val map = HashMap<Char, Int>()
        s.forEach {
            val cnt = map[it] ?: 0
            map[it] = cnt + 1
        }
        var result = ""
        val sortedPairList = map.filter { it.value > 1 }.toList().sortedWith(compareBy { it.second })
        if (sortedPairList.isEmpty()) return s
        val map2 = linkedMapOf(*sortedPairList.toTypedArray())
        val maxBut2 = map2.maxBy { it.value }
        map.filter { it.value == 1 }.forEach { result += it.key }

//
//        if (result.isEmpty()) {
            map2[maxBut2.key] = map2[maxBut2.key]!! - 1
            result = result + "${maxBut2.key}"
//        }

        map2.forEach {
            val birxillar = HashSet<Char>()
            val uzunlik = it.value
            var birkatta:Char? =null
            map2.filter { inner -> (inner.value == it.value || inner.value + 1 == it.value) && it.value > 0}.forEach { birxil ->
                birxillar.add(birxil.key)
                if (birxil.value + 1 == it.value) {
                    birkatta = birxil.key
                }
            }

            if(birxillar.size>1) {
                birxillar.forEach {
                    map2[it] = 0
                }
                if (birkatta != null){
                    map2[birkatta!!] = 1
                }
                var rr = ""
                for (i in 0 until uzunlik) {
                    birxillar.forEach { rr += it }
                }

                if (result.isEmpty()) {
                    result = rr
                } else {
                    if (rr[rr.length-1] != result[0]) {
                        result = rr + result
                    } else {
                        result += rr
                    }
                }
            }
        }



        map2.forEach {

            val birxillar = HashSet<Char>()
            val uzunlik = it.value
            map2.filter { inner -> inner.value == it.value && it.value > 0}.forEach { birxil ->
                birxillar.add(birxil.key)
            }

            if(birxillar.size>1) {
                birxillar.forEach {
                    map2[it] = 0
                }
                var rr = ""
                for (i in 0 until uzunlik) {
                    birxillar.forEach { rr += it }
                }

                if (result.isEmpty()) {
                    result = rr
                } else {
                    if (rr[0] == result[0]) {
                        result = rr + result
                    } else {
                        result += rr
                    }
                }
            }

            if (it.value > result.length + 1) {
                return ""
            }
            var i = 0
            while (i < it.value * 2) {
                result = "${result.substring(0, i)}${it.key}${result.substring(i)}"
                i += 2
            }
        }

        return result
    }

}