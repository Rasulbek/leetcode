package leetcode

fun main() {
    println(SortVowels().sortVowels("lEetcOde"))
    println(SortVowels().sortVowels("lYmpH"))
}
class SortVowels {
    fun sortVowels(s: String): String {
        val lst = ArrayList<Char>()
        val result = ArrayList<Char>()
        s.forEach {
            if (it =='A'
                || it == 'a'
                || it == 'E'
                || it == 'e'
                || it == 'I'
                || it == 'i'
                || it == 'O'
                || it == 'o'
                || it == 'U'
                || it == 'u'
            ) {
                lst.add(it)
                result.add('-')
            } else {
                result.add(it)
            }
        }

        var javob = StringBuffer()
        lst.sort()
        var i =0
        result.forEach {
            if (it == '-') {
                javob.append(lst[i])
                i++
            } else {
                javob.append(it)
            }
        }
        return javob.toString()
    }
}