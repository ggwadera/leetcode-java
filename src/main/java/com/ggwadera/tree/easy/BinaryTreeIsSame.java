package com.ggwadera.tree.easy;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/same-tree">100. Same Tree</a>
 */
public class BinaryTreeIsSame {

    /**
     * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
     * <p>
     * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }

}
