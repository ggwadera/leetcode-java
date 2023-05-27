package com.ggwadera.medium;

import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/rotate-list">61. Rotate List</a>
 */
public class RotateLinkedList {

    /**
     * Given the head of a linked list, rotate the list to the right by k places.
     * <p>
     * Example: [1, 2, 3, 4, 5] and k = 2
     * <p>
     * Will return [4, 5, 1, 2, 3]
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        // Find the tail and length of the list;
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }

        k = k % n;
        if (k == 0) return head;

        tail.next = head;
        ListNode node = head;

        for (int i = 0; i < n - k - 1; i++) {
            node = node.next;
        }

        head = node.next;
        node.next = null;

        return head;
    }
}
