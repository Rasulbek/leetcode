package leetcode
//
//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}

fun main() {
    val head = ListNode(3).apply {
        next = ListNode(2).apply {
            next = ListNode(0).apply {
                next = ListNode(4)
            }
        }
    }
    val h2 = ListNode(1)
    val h22 = ListNode(2)
    h2.next = h22
    println(HasCycle().hasCycle(h2))
}

class HasCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        var slow = head
        var fast = head
        while (fast?.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
            if (fast==slow) return true
        }
        return false
    }
}