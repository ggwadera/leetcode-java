package com.ggwadera.easy;

import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/merge-two-sorted-lists">21. Merge Two Sorted Lists</a>
 */
public class MergeSortedLinkedLists {

    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     * <p>
     * Merge the two lists in a one sorted list.
     * The list should be made by splicing together the nodes of the first two lists.
     * <p>
     * Return the head of the merged linked list.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;
        return head.next;
    }
}
