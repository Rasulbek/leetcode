package leetcode

fun main() {
//    println(ConcatWords().findSubstring("barfoothefoobarman", listOf("foo", "bar").toTypedArray()))
//    println(
//        ConcatWords().findSubstring(
//            "wordgoodgoodgoodbestword",
//            listOf("word", "good", "best", "word").toTypedArray()
//        )
//    )
//    println(ConcatWords().findSubstring("barfoofoobarthefoobarman", listOf("bar", "foo", "the").toTypedArray()))
    println(ConcatWords().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", listOf("fooo","barr","wing","ding","wing").toTypedArray()))
//    println(
//        ConcatWords().findSubstring(
//            "wordgoodgoodgoodbestword",
//            listOf("word", "good", "best", "good").toTypedArray()
//        )
//    ) // 8
}

class ConcatWords {

    val wcounts = HashMap<String, Int>()
    var words: Array<String> = emptyArray()
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = ArrayList<Int>()
        this.words = words
        clearCounts()

        val wl = words[0].length
        val sl = words.size * wl

        if (sl > s.length) return emptyList()

        var i = 0
        while (i <= s.length - sl) {
            var sbstrign = s.substring(i, i + sl)
            var b = true
            var j = 0
            while (b && j < sl) {
                var lsbt = sbstrign.substring(0, wl)
                sbstrign = sbstrign.substring(wl)
                j += wl
                if (wcounts.contains(lsbt)) {
                    if (wcounts[lsbt] == 0) {
                        j -= wl
                        clearCounts()
                        b = false
                    } else {
                        wcounts[lsbt] = wcounts[lsbt]!! - 1
                    }
                } else {
                    clearCounts()
                    b = false
                }
            }
            if (!b) {
                i += 1
            } else {
                var buzuq = false
                for (a in wcounts.keys) {
                    if (wcounts[a] != 0) {
                        buzuq = true
                    }
                }
                if (!buzuq) {
                    result.add(i)
                    i += wl
                    clearCounts()
                }
            }
        }


        return result
    }

    fun clearCounts() {
        for (s in wcounts.keys) {
            wcounts[s] = 0
        }
        for (s in words) {
            wcounts[s] = wcounts.getOrDefault(s, 0) + 1
        }
    }
}