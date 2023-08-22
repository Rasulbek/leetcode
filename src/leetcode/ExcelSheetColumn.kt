package leetcode

fun main() {
//    println(ExcelSheetColumn().convertToTitle(1))
//    println(ExcelSheetColumn().convertToTitle(2))
//    println(ExcelSheetColumn().convertToTitle(25))
//    println(ExcelSheetColumn().convertToTitle(26))
//    println(ExcelSheetColumn().convertToTitle(27))
//    println(ExcelSheetColumn().convertToTitle(28))
//    println(ExcelSheetColumn().convertToTitle(29))
    println(ExcelSheetColumn().convertToTitle(52))
}
class ExcelSheetColumn {
    fun convertToTitle(columnNumber: Int): String {
        var s = columnNumber
        var r = ""
        while (s > 26) {
            val s1 = s % 26
            r = "${(s1 + 64).toChar()}$r"
            s /= 26
        }
        r = "${(s + 64).toChar()}$r"
        return r.replace('@','Z')
    }
}