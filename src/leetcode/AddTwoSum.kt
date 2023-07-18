package leetcode

import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val t1 = ListNode(7).apply {
        next = ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }
    }
    val t2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }
//    println(AddTwoSum().addTwoNumbers(t1, t2))
    println(AddTwoSum().addTwoNumbers(ListNode(0), ListNode(0)))
}

class SonNode(var value: Int) {
    var parent: SonNode? = null
}

class AddTwoSum {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var first = SonNode(l1?.`val` ?: 0)
        var second = SonNode(l2?.`val` ?: 0)
        if (l1 == null && l2 == null) {
            return ListNode(0)
        }
        if (l1 == null) {
            return l2
        }
        if (l2 == null) {
            return l1
        }
        var a = l1.next
        var b = l2.next

        var len1 = 0
        var len2 = 0
        while (a != null) {
            first = SonNode(a.`val`).also {
                it.parent = first
            }
            a = a.next
            len1++
        }

        while (b != null) {
            second = SonNode(b.`val`).also {
                it.parent = second
            }
            b = b.next
            len2++
        }

        return if (len1 > len2) {
            addThese(first, second)
        } else {
            addThese(second, first)
        }

    }

    fun addThese(first: SonNode, second: SonNode): ListNode {
        addNext(first, second)

        var a = first.parent
        var b = second.parent
        while (b != null) {
            addNext(a!!, b)
            a = a.parent
            b = b.parent
        }

        var k = first.parent
        var n = ListNode(first.value)
        while (k != null) {
            n = ListNode(k.value).also {
                it.next = n
            }
            k = k.parent
        }

        return n
    }

    fun addNext(first: SonNode, second: SonNode) {
        if (first.value + second.value > 9) {
            first.value = (first.value + second.value) % 10
            increaseParent(first)
        } else {
            first.value = first.value + second.value
        }
    }

    fun increaseParent(first: SonNode) {
        if (first.parent == null) {
            first.parent = SonNode(1)
        } else {
            if (first.parent!!.value + 1 > 9) {
                first.parent!!.value = 0
                increaseParent(first.parent!!)
            } else {
                first.parent!!.value = first.parent!!.value + 1
            }
        }
    }

}