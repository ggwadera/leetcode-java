package com.ggwadera.easy;

import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/linked-list-cycle">141. Linked List Cycle</a>
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        // Use a slow and a fast moving pointer
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // Slow pointer moves by one step
            slow = slow.next;

            // Fast pointer moves by two steps
            fast = fast.next.next;

            // If both point to the same node, the list has a cycle
            if (slow == fast) return true;
        }

        // Out of the loop, so no cycle detected
        return false;
    }

}
