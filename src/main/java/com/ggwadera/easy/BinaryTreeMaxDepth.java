package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">104. Maximum Depth of Binary Tree</a>
 */
public class BinaryTreeMaxDepth {

    /**
     * Given the root of a binary tree, return its maximum depth.
     * <p>
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
