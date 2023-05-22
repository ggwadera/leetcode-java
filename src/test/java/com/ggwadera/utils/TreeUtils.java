package com.ggwadera.utils;

import com.ggwadera.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeUtils {
    /**
     * Parses and build a binary tree where the values are given by the tree's level.
     * For example, the input:
     * <p>
     * <code>6, 2, 8, 0, 4, null, 9</code>
     * <p>
     * will return the following tree:
     * <p>
     * <pre>
     *         6
     *        / \
     *       2   8
     *      / \   \
     *     0   4   9
     * </pre>
     *
     * @param nodes the tree nodes by height, may contain null values
     * @return the parsed binary tree data structure
     */
    public static TreeNode parseTree(Integer... nodes) {
        if (nodes == null || nodes.length == 0) return null;
        int n = nodes.length, i = 0;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (i < n && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            node.left = getNextTreeNode(nodes, ++i);
            node.right = getNextTreeNode(nodes, ++i);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    private static TreeNode getNextTreeNode(Integer[] nodes, int i) {
        if (i < nodes.length && nodes[i] != null) {
            return new TreeNode(nodes[i]);
        }
        return null;
    }

    public static boolean treesAreEqual(TreeNode a, TreeNode b) {
        if (a == b) return true;
        if (a == null || b == null) return false;
        return a.val == b.val
            && treesAreEqual(a.left, b.left)
            && treesAreEqual(a.right, b.right);
    }
}
