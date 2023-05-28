package com.ggwadera.linkedlist.medium;

/**
 * Solution for <a href="https://leetcode.com/problems/copy-list-with-random-pointer">138. Copy List with Random Pointer</a>
 */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     *  A linked list of length n is given such that each node contains an additional random pointer,
     *  which could point to any node in the list, or null.
     * <p>
     * Construct a deep copy of the list.
     * The deep copy should consist of exactly n brand new nodes, where each new node
     * has its value set to the value of its corresponding original node.
     * Both the next and random pointer of the new nodes should point to new nodes in the copied
     * list such that the pointers in the original list and copied list represent the same list state.
     * None of the pointers in the new list should point to nodes in the original list.
     */
    public Node copyRandomList(Node head) {

        // Create copies intertwined between the existing nodes (A' is the copy)
        // A -> B -> C -> D
        // A -> A' -> B -> B' -> C -> C' -> D -> D'
        Node node = head;
        while (node != null) {
            var tmp = node.next;
            node.next = new Node(node.val);
            node.next.next = tmp;
            node = tmp;
        }

        // Assign the random pointers to the copies
        // A.random = C
        // C.next = C'
        // A'.random = A.random.next = C'
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        // Restore the list links and move the copies to another list
        // A  -> B  -> C  -> D
        // A' -> B' -> C' -> D'
        var newHead = new Node(0);
        var current = newHead;
        node = head;
        while (node != null) {
            current.next = node.next;
            current = current.next;

            node.next = node.next.next;
            node = node.next;
        }
        return newHead.next;
    }
}
