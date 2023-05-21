package com.ggwadera.easy;

import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/reverse-linked-list">206. Reverse Linked List</a>
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            var next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseListRecursion(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        var next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }
}
