package com.ggwadera.tree.medium;

import com.ggwadera.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for <a href="https://leetcode.com/problems/even-odd-tree">1609. Even Odd Tree</a>
 */
public class EvenOddTree {

    /**
     * A binary tree is named Even-Odd if it meets the following conditions:
     * <ul>
     * <li>The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.</li>
     * <li>For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).</li>
     * <li>For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).</li>
     * </ul>
     * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
     */
    public boolean isEvenOddTree(TreeNode root) {
        boolean evenLevel = true;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode current = root;
        queue.add(current);
        while (!queue.isEmpty()) {
            int previous = evenLevel ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int size = queue.size(); size > 0; size--) {
                current = queue.poll();
                int val = current.val;
                if (evenLevel) {
                    if (isEven(val) || val <= previous) return false;
                } else {
                    if (!isEven(val) || val >= previous) return false;
                }
                previous = val;
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            evenLevel = !evenLevel;
        }
        return true;
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

}
