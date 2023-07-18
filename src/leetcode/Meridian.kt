package leetcode


class Meridian {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        if (n == 0 || m == 0) {
            if (n > 0) {
                return findMeridian(nums1)
            }
            if (m > 0) {
                return findMeridian(nums2)
            }
            return 0.0
        }

        val size = (n + m) / 2 + 1
        val newList = IntArray(size)
        var i = 0
        var nIndex = 0
        var mIndex = 0
        while (i < size) {
            if (nIndex < nums1.size && mIndex < nums2.size) {
                if (nums1[nIndex] < nums2[mIndex]) {
                    newList[i] = nums1[nIndex]
                    nIndex++
                } else {
                    newList[i] = nums2[mIndex]
                    mIndex++
                }
            } else if (nIndex >= nums1.size) {
                newList[i] = nums2[mIndex]
                mIndex++
            } else {
                newList[i] = nums1[nIndex]
                nIndex++
            }
            i++
        }
        return if ((nums1.size + nums2.size) % 2 == 1) {
            newList[size - 1] / 1.0
        } else {
            (newList[size - 2] + newList[size - 1]) / 2.0
        }
    }

    private fun findMeridian(nums: IntArray): Double {
        if (nums.isEmpty()) {
            return 0.0
        }
        if (nums.size == 1) {
            return nums[0] / 1.0
        }
        if (nums.size == 2) {
            return (nums[0] + nums[1]) / 2.0
        }
        if (nums.size % 2 == 1) {
            return nums[(nums.size / 2)] / 1.0
        }
        return (nums[(nums.size / 2)] + nums[(nums.size / 2) - 1]) / 2.0
    }
}