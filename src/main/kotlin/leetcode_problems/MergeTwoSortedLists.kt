package leetcode_problems

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution5 {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        val sentinel = ListNode(-1)
        var currentTail = sentinel

        var pointer1 = list1
        var pointer2 = list2

        while (pointer1 != null && pointer2 != null) {
            if (pointer1.`val` < pointer2.`val`) {

                currentTail.next = pointer1

                pointer1 = pointer1.next
            } else {

                currentTail.next = pointer2

                pointer2 = pointer2.next
            }

            currentTail = currentTail.next!!
        }

        currentTail.next = pointer1 ?: pointer2

        return sentinel.next
    }

}


fun main() {
    println("This is merge two sorted lists test")
}

