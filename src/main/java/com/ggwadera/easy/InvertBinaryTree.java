package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for <a href="https://leetcode.com/problems/invert-binary-tree">226. Invert Binary Tree</a>
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode left = current.left;
            TreeNode right = current.right;
            current.right = left;
            current.left = right;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }
        return root;
    }

}
