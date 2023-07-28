package leetcode


fun main() {
    println(WaterContainer().maxArea(arrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7).toIntArray()))
    println(WaterContainer().maxArea(arrayOf(1, 1).toIntArray()))
}

class WaterContainer {
    fun maxArea(height: IntArray): Int {
        val ln = height.size -1
        var i = 0
        var j: Int
        var max = if (height[0] < height[ln]) height[0] * ln else height[ln] * ln
        var min: Int
        var tmpMax: Int
        while (i < ln) {
            j = ln
            while (j > i) {
                if ((j - i) * height[i] < max) {
                    break
                }
                min = if (height[i] < height[j]) height[i] else height[j]
                tmpMax = min * (j - i)
                if (tmpMax > max) max = tmpMax
                j--
            }
            i++
        }
        return max
    }
}