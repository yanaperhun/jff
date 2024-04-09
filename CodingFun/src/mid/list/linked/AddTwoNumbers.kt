package mid.list.linked

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 *  Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val resultHead = ListNode(0)
        var current = resultHead
        var carry = 0
        var headOne = l1
        var headTwo = l2

        while (headOne != null || headTwo != null) {
            val x = headOne?.`val` ?: 0
            val y = headTwo?.`val` ?: 0
            val sum = x + y + carry
            carry = sum / 10
            current.next = ListNode(sum % 10)
            current = current.next!!
            headOne = headOne?.next
            headTwo = headTwo?.next
        }

        if (carry > 0) {
            current.next = ListNode(carry)
        }

        return resultHead.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}