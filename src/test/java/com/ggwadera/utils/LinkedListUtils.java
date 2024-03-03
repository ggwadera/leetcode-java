package com.ggwadera.utils;

import com.ggwadera.common.ListNode;
import org.assertj.core.api.Condition;


public class LinkedListUtils {

    /**
     * Build a linked list from an array of integers, where each integer is linked to the next one.
     * @param nodes the linked list nodes, in order of connection
     * @return the head of the linked list
     */
    public static ListNode parseLinkedList(int... nodes) {
        if (nodes == null || nodes.length == 0) return null;
        ListNode head = new ListNode(nodes[0]);
        ListNode current = head;
        for (int i = 1; i < nodes.length; i++) {
            ListNode node = new ListNode(nodes[i]);
            current.next = node;
            current = node;
        }
        return head;
    }

    /**
     * Compare two linked lists to check if they are the same, that is, if they have the same values.
     * @param a first linked list
     * @param b second linked list
     * @return true if the linked lists have the length and values, false otherwise.
     */
    public static boolean linkedListsAreEqual(ListNode a, ListNode b) {
        while (a != null || b != null) {
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }

    public static Condition<ListNode> isEqualTo(ListNode expected) {
        return new Condition<>(node -> linkedListsAreEqual(node, expected), "LinkedLists should be equal");
    }
}
