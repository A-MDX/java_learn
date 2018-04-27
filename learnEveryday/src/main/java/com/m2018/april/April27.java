package com.m2018.april;

import java.util.Stack;

/**
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * Create by A-mdx at 2018-04-27 21:20
 * 这道题似乎做过
 */
public class April27 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // 看别人的，感觉也是机智的不行
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                node.left.val += node.val;
                stack.push(node.left);
            }
            if (node.right != null) {
                node.right.val += node.val;
                stack.push(node.right);
            }
            if (node.left == null && node.right == null) {
                if (sum == node.val) {
                    return true;
                }
            }
        }
        return false;
    }

    // 这个方法太过简单，试试难的
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        helper(root, 0, sum);
        return hasPath;
    }

    boolean hasPath = false;

    private void helper(TreeNode node, int num, int sum) {
        num += node.val;
        if (node.left == null && node.right == null) {
            if (sum == num) {
                hasPath = true;
            }
            return;
        }
        if (node.left != null) {
            helper(node.left, num, sum);
        }
        if (node.right != null) {
            helper(node.right, num, sum);
        }
    }
}
