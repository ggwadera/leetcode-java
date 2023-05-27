package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution for <a href="https://leetcode.com/problems/binary-tree-inorder-traversal">94. Binary Tree Inorder Traversal</a>
 */
public class BinaryTreeInOrderTraversal {

    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        return inOrder;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public List<Integer> iterativeInorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            inOrder.add(current.val);
            current = current.right;
        }

        return inOrder;
    }
}
