package com.ggwadera.medium;

import com.ggwadera.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal">105. Construct Binary Tree from Preorder and Inorder Traversal</a>
 */
public class BinaryTreeFromPreorderAndInorder {

    private final Map<Integer, Integer> map = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        root.left = arrayToTree(preorder, start, map.get(root.val) - 1);
        root.right = arrayToTree(preorder, map.get(root.val) + 1, end);
        return root;
    }
}
