package com.m2018.january;

/**
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Created By a-mdx on 2018/1/16 上午11:29
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class January16 {
    public int maxDepth(TreeNode root) {
        return checkDepth(root, 0);
    }

    private int checkDepth(TreeNode node, int nowDepth){
        if (node == null){
            return nowDepth;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;

        return Math.max(checkDepth(left, nowDepth+1), checkDepth(right, nowDepth+1));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int num) {
            val = num;
        }
    }
}
