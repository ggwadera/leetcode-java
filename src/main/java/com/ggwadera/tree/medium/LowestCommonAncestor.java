package com.ggwadera.tree.medium;

import com.ggwadera.common.TreeNode;

/**
 * Solution for <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree">235. Lowest Common Ancestor of a Binary Search Tree</a>
 */
public class LowestCommonAncestor {

    /**
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
     * <p>
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T
     * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     */
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
