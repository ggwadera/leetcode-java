package com.ggwadera;

import com.ggwadera.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public final class TestUtils {

    private TestUtils() {
    }

    /**
     * Parse a matrix string in the format [[0, 0], [0, 0]]
     *
     * @param matrixString the matrix as a string
     * @param m            number of rows
     * @param n            number of columns
     * @return the parsed matrix as an array of arrays
     */
    public static int[][] parseMatrix(String matrixString, int m, int n) {
        int[][] matrix = new int[m][n];
        String[] rows = matrixString.replaceAll("[ \\[]", "")
            .replaceAll("],", " ")
            .replaceAll("]", "")
            .split(" ");
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split(",");
            for (int j = 0; j < columns.length; j++) {
                matrix[i][j] = Integer.parseInt(columns[j]);
            }
        }
        return matrix;
    }

    /**
     * Parses and build a binary tree where the values are given by the tree's level.
     * For example, the input: 6, 2, 8, 0, 4; will return a tree with 5 nodes, with 6 as the root, and a height of 3.
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
