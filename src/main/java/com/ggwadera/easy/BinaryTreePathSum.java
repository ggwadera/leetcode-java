package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/path-sum">112. Path Sum</a>
 */
public class BinaryTreePathSum {

    /**
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
     * that adding up all the values along the path equals targetSum.
     * <p>
     * A leaf is a node with no children.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int newTarget = targetSum - root.val;
        return hasPathSum(root.left, newTarget)
            || hasPathSum(root.right, newTarget);
    }

}
