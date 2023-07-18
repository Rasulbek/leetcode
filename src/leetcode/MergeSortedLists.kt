package leetcode

//
//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}
//
//
//class MergeSortedLists {
//
//    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
//        var result = ListNode()
//    }
//
//}
fun threeSum(nums1: IntArray): List<List<Int>> {
    val setOfExists = HashSet<String>()
    val resultList = ArrayList<List<Int>>()
    val nums = nums1.sorted()
    for (i in 0 until nums.size - 2) {
        for (j in i + 1 until nums.size - 1) {
            for (k in j + 1 until nums.size) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    //check if set has this list
                    val sublist = arrayListOf(nums[i], nums[j], nums[k]).sorted()
                    val txt = "${sublist[0]}+${sublist[1]}+${sublist[2]}"
                    if (!setOfExists.contains(txt)) {
                        setOfExists.add(txt)
                        resultList.add(sublist)
                    }
                    break
                } else {
                    if (nums[j] == nums[k]) {

                    }
                }
            }
        }
    }
    return resultList
}

fun maxProfit(prices: IntArray): Int {
    var max = 0
    var min = 10001
    var best = 0
    for (i in prices.indices) {
        if (prices[i] < min) {
            min = prices[i]
            max = min
        }
        if (prices[i] > max) {
            max = prices[i]
            if (best < max - min) {
                best = max - min
            }
        }
    }
    return best
}

fun maxProfit2(prices: IntArray): Int {
    var profit = 0

    var max = 0
    var min = 10001
    var i = 0

    while (i < prices.size) {
        if (prices[i] < max) {
            profit += max - min
            max = prices[i]
            min = prices[i]
        }
        if (prices[i] < min) {
            min = prices[i]
        }
        if (prices[i] > max) {
            max = prices[i]
        }

        i++
    }
    return profit + (max-min)
}

fun main() {

    println(maxProfit2(arrayOf(7, 1, 5, 3, 6, 4).toIntArray()))
    println(maxProfit2(arrayOf(1, 2, 3, 4, 5).toIntArray()))
    println(maxProfit2(arrayOf(7, 6, 4, 3, 1).toIntArray()))
    println(maxProfit2(arrayOf(2, 4, 1).toIntArray()))
//    val case = arrayOf(3,0,-2,-1,1,2)
//    val case = arrayOf(0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, -1)
////    val case = arrayOf(82597,-9243,62390,83030,-97960,-26521,-61011,83390,-38677,12333,75987,46091,83794,19355,-71037,-6242,-28801,324,1202,-90885,-2989,-95597)
//    val result = threeSum(case.toIntArray())


//    val case1 = arrayOf(1, 2, 3, 4, 5, 6)
//    val case1 = arrayOf(-1, -100, 3, 99)
//    val case1 = arrayOf(1,2)
//    rotate(case1.toIntArray(), 3)

//    val case1 = arrayOf(1,2,1,2,3,1,2,3,3,1,2,1,2,3,3,3)
//    val result = majorityElement2(case1.toIntArray())
//    println(result)

//    merge(arrayOf(1, 2,3,0,0,0).toIntArray(), 3, arrayOf(2,5,6).toIntArray(), 3)
//    merge(arrayOf(0).toIntArray(), 0, arrayOf(1).toIntArray(), 1)
//    merge(arrayOf(1).toIntArray(), 1, IntArray(0), 0)

//    val case1 = arrayOf(1,2,3,4,5,2,2,3,4,5)
//    val case2 = arrayOf(3,2,2,3)
//    val case3 = arrayOf(0,1,2,2,3,0,4,2)
//    removeElement(case3.toIntArray(), 2)

//    val case1 = arrayOf(1,1,2)
//    val case1 = arrayOf(0,0,1,1,1,2,2,3,3,3,4,5,5,5,6,7)
//    val case1 = arrayOf(0,0,1,1,1,2,2,3,3,3,4,5,5,5,6,7)

//    val case1 = arrayOf(1,1,1,2,2,3)
//    val result = removeDuplicates(case1.toIntArray())
//    print(result)
}


fun rotate(nums: IntArray, kk: Int): Unit {
    val size = nums.size
    if (kk == 0 || kk == size) {
        return
    }
    val k = kk % size
    var i: Long = 0
    var cnt = 0
    var bir = nums[0]
    var ikki: Int
    var turns = 0
    while (cnt < size) {
        ikki = nums[((i + k) % size).toInt()]
        nums[((i + k) % size).toInt()] = bir
        bir = ikki
        if (((i + k - turns) % size).toInt() == 0 && cnt > 0) {
            i++
            bir = nums[((i + k) % size).toInt()]
            turns++
        }
        i += k
        cnt++

    }
    i = 0
    while (i < nums.size) {
        print("${nums[i.toInt()]} ")
        i++
    }
}

fun majorityElement2(nums: IntArray): Int {
    val cnts = IntArray(50000)
    var maxOccurrence = 0
    var maxIndex = 0
    for (i in nums.indices) {
        cnts[nums[i]] = cnts[nums[i]] + 1
        if (cnts[nums[i]] > maxOccurrence) {
            maxOccurrence = cnts[nums[i]]
            maxIndex = i
        }
        if (maxOccurrence > (nums.size / 2) + 1) {
            return nums[i]
        }
    }
    return nums[maxIndex]
}

fun majorityElement(nums: IntArray): Int {
    val qaysiSonNechaMarta = HashMap<Int, Int>()
    val nechaMartaQaysiSon = HashMap<Int, Int>()
    var maxOccurrences = 1
    qaysiSonNechaMarta[nums[0]] = 1
    nechaMartaQaysiSon[1] = nums[0]
    var i = 1
    var cnt = 0
    while (i < nums.size) {
        if (qaysiSonNechaMarta.containsKey(nums[i])) {
            cnt = qaysiSonNechaMarta[nums[i]]!! + 1
            qaysiSonNechaMarta[nums[i]] = cnt
            if (cnt > maxOccurrences) {
                nechaMartaQaysiSon.remove(maxOccurrences)
                maxOccurrences = cnt
                nechaMartaQaysiSon[maxOccurrences] = nums[i]
            }
        } else {
            qaysiSonNechaMarta[nums[i]] = 1
            nechaMartaQaysiSon[1] = nums[i]
        }
        i++
    }
    return nechaMartaQaysiSon[maxOccurrences]!!
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var index1 = 0
    var index2 = 0
    val mNums = IntArray(m)
    for (i in 0 until m) {
        mNums[i] = nums1[i]
    }
    var i = 0
    while (i < m + n) {
        if (index1 >= m) {
            nums1[i] = nums2[index2]
            index2++
        } else if (index2 >= n) {
            nums1[i] = mNums[index1]
            index1++
        } else if (mNums[index1] <= nums2[index2]) {
            nums1[i] = mNums[index1]
            index1++
        } else {
            nums1[i] = nums2[index2]
            index2++
        }
        i++
    }

    for (i in 0 until (n + m)) {
        print("${nums1[i]} ")
    }
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var count = 0
    val missingIndexes = mutableListOf<Int>()
    for (i in nums.indices) {
        if (nums[i] == `val`) {
            nums[i] = -1
            missingIndexes.add(i)
        } else {
            if (missingIndexes.size > 0) {
                nums[missingIndexes.first()] = nums[i]
                missingIndexes.removeAt(0)
                nums[i] = -1
                missingIndexes.add(i)
            }
            count++
        }
    }

    nums.forEach {
        print("$it ")
    }

    print("\n Count: $count")
    return count
}

fun removeDuplicates(nums: IntArray): Int {
//    var count = 0
    var current = nums[0]
    var duplicates = 0
    var isSecond = false
    var i = 1
    while (i < nums.size && nums[i] != -100000) {
        if (current == nums[i]) {
            if (!isSecond) {
                isSecond = true
                i++
            } else {
                duplicates++
                for (j in (i + 1) until (nums.size - duplicates + 1)) {
                    nums[j - 1] = nums[j]
                }
                nums[nums.size - duplicates] = -100000
            }
        } else {
            current = nums[i]
            isSecond = false
            i++
        }
    }

    nums.forEach {
        print("$it ")
    }
    println()

    return nums.size - duplicates
}