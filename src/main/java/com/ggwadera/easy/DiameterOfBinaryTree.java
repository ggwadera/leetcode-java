package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/diameter-of-binary-tree">543. Diameter of Binary Tree</a>
 */
public class DiameterOfBinaryTree {

    /**
     * Global variable to hold the maximum diameter found during recursion
     */
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    /**
     * Finds the depth of a subtree, also calculating the diameter for each node.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root
     * @param node the subtree root node
     * @return the largest depth for the subtree
     */
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

}
