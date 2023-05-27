package com.ggwadera.easy;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/symmetric-tree">101. Symmetric Tree</a>
 */
public class BinaryTreeIsSymmetric {

    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
            && check(left.left, right.right)
            && check(left.right, right.left);
    }

}
