package com.ggwadera.medium;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree">235. Lowest Common Ancestor of a Binary Search Tree</a>
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pNode, TreeNode qNode) {
        if (root == null) return null;

        int p = pNode.val;
        int q = qNode.val;
        int node = root.val;

        if (p < node && q < node) {
            return lowestCommonAncestor(root.left, pNode, qNode);
        } else if (p > node && q > node) {
            return lowestCommonAncestor(root.right, pNode, qNode);
        }
        return root;
    }
}
