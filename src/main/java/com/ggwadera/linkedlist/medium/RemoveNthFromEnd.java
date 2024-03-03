package com.ggwadera.linkedlist.medium;

import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>
 */
public class RemoveNthFromEnd {

    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a sentinel node at the start of the list
        ListNode sentinel = new ListNode(0, head);

        // Use a slow and fast pointer, starting at the sentinel's position
        ListNode node = sentinel, tail = sentinel;

        // Move the fast pointer `n` positions ahead
        for (int i = 0; i <= n; i++) {
            tail = tail.next;
        }
        // Move both pointers until reaching the end of the list
        while (tail != null) {
            tail = tail.next;
            node = node.next;
        }

        // The slow pointer will be positioned just before the node to be removed
        node.next = node.next.next;

        return sentinel.next;
    }

}
