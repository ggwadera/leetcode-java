package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/balanced-binary-tree">110. Balanced Binary Tree</a>
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != -1;
    }

    // Find the depth of a node using recursion (-1 == unbalanced)
    private static int dfs(TreeNode root) {
        // Base case
        if (root == null) return 0;

        // Depth of the left subtree
        int depthLeft = dfs(root.left);
        if (depthLeft == -1) return -1; // unbalanced

        // Depth of the right subtree
        int depthRight = dfs(root.right);
        if (depthRight == -1) return -1; // unbalanced

        // If the subtrees are unbalanced, return -1
        if (Math.abs(depthLeft - depthRight) > 1) return -1;

        // Return the depth of this node
        return Math.max(depthLeft, depthRight) + 1;
    }
}
