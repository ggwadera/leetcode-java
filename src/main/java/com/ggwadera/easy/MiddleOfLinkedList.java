package com.ggwadera.easy;

import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/middle-of-the-linked-list">876. Middle of the Linked List</a>
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        // Use a slow and a fast moving pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            // Slow pointer moves a single step
            slow = slow.next;
            // Fast pointer moves two steps
            fast = fast.next.next;
        }
        // When fast pointer reaches the end of the list, the slow pointer will be in the middle.
        return slow;
    }
}
