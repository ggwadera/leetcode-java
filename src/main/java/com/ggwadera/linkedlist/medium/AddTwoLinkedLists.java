package com.ggwadera.linkedlist.medium;

import com.ggwadera.common.ListNode;

/**
 * Solution for <a href="https://leetcode.com/problems/add-two-numbers">2. Add Two Numbers</a>
 */
public class AddTwoLinkedLists {

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode current = ans;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        return ans.next;
    }
}
