package leetcode

fun main() {

}

class TwoString {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        return word1.joinToString("") == word2.joinToString("")
    }

    fun countCharacters(words: Array<String>, chars: String): Int {
        val charsMap = mutableMapOf<Char, Int>()
        chars.forEach {
            charsMap[it] = charsMap.getOrDefault(it, 0) + 1
        }
        var result = 0
        words.forEach { word ->
            val wordMap = mutableMapOf<Char, Int>()
            word.forEach {
                wordMap[it] = wordMap.getOrDefault(it, 0) + 1
            }
            var isGood = true
            wordMap.forEach { (key, value) ->
                if (charsMap.getOrDefault(key, 0) < value) {
                    isGood = false
                }
            }
            if (isGood) {
                result += word.length
            }
        }
        return result
    }
}