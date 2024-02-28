package com.ggwadera.tree.medium;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/find-bottom-left-tree-value/">513. Find Bottom Left Tree Value</a>
 */
public class FindBottomLeftTreeValue {

    private int maxDepth = Integer.MIN_VALUE;
    private int leftmost = 0;

    /**
     * Given the root of a binary tree, return the leftmost value in the last row of the tree.
     */
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return leftmost;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        // The leftmost value will be the first node when reaching a new maximum depth
        if (depth > maxDepth) {
            maxDepth = depth;
            leftmost = root.val;
        }
    }

}
