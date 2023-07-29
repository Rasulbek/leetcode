package leetcode

fun main() {
    println(ThreeSum().threeSum(arrayOf(-1, 0, 1, 2, -1, -4).toIntArray()))
    println(ThreeSum().threeSum(arrayOf(0, 1, 1).toIntArray()))
    println(ThreeSum().threeSum(arrayOf(0, 0, 0).toIntArray()))
    println(ThreeSum().threeSum(arrayOf(-1, 0, 1, 0).toIntArray()))
}

class ThreeSum {

    fun threeSum(nums1: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()

        val arr = nums1.sortedArray()
        val map = HashMap<Int, Int>()
        arr.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        val l1 = ArrayList<Pair<Int, Int>>()

        var i = 0

        while (i < arr.size - 2) {
            var j = i + 1
            while (j < arr.size - 1) {
                val sbt = (0 - arr[i] - arr[j])
                val sn: Int = map[sbt] ?: 0
                if (sn == 0) {
                    j++
                    continue
                }

                if (l1.contains(Pair(arr[i], arr[j])) ||
                    l1.contains(Pair(arr[i], sbt)) ||
                    l1.contains(Pair(arr[j],sbt))
                ) {
                    j++
                    continue
                }

                if ((sbt == arr[i] && sbt == arr[j] && sn > 2) || ((sbt == arr[i] || sbt == arr[j]) && arr[i] != arr[j] && sn > 1) || (sbt != arr[i] && sbt != arr[j])) {
                    l1.add(Pair(arr[i], arr[j]))
                    l1.add(Pair(arr[j], arr[i]))
                    l1.add(Pair(arr[i], sbt))
                    l1.add(Pair(sbt, arr[i]))
                    l1.add(Pair(arr[j], sbt))
                    l1.add(Pair(sbt, arr[j]))
                    result.add(listOf(arr[i], arr[j], sbt))
                }
                j++
            }
            i++
        }

        return result
    }

}