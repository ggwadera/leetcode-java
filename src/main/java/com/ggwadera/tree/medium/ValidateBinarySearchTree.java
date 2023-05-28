package com.ggwadera.tree.medium;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/validate-binary-search-tree">98. Validate Binary Search Tree</a>
 */
public class ValidateBinarySearchTree {

    private TreeNode previous = null;

    /**
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
     * <p>
     * A valid BST is defined as follows:
     * <ul>
     * <li>The left subtree of a node contains only nodes with keys less than the node's key.</li>
     * <li>The right subtree of a node contains only nodes with keys greater than the node's key.</li>
     * <li>Both the left and right subtrees must also be binary search trees.</li>
     * </ul>
     */
    public boolean isValidBST(TreeNode root) {
        // In order traversal to validate the binary search tree
        // Left < Root < Right
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node) {
        if (node == null) return true;

        if (!inOrder(node.left)) return false;

        if (previous != null && node.val <= previous.val) return false;

        previous = node;

        return inOrder(node.right);
    }
}
