package com.ggwadera.medium;


import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list">2095. Delete the Middle Node of a Linked List</a>
 */
public class DeleteMiddleOfLinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode middlePredecessor = findMiddleNodePredecessor(head);
        middlePredecessor.next = middlePredecessor.next.next;
        return head;
    }

    /**
     * Finds the middle predecessor node of the linked list using a slow and fast pointers.
     * @param head head of the linked list
     * @return the middle predecessor node
     */
    private ListNode findMiddleNodePredecessor(ListNode head) {
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
