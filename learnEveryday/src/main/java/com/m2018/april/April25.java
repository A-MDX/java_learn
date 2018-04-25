package com.m2018.april;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * Create by A-mdx at 2018-04-25 22:46
 * 自上而下的递归方法，似乎还是第一次感受。。。
 */
public class April25 {

    // 自上而下
    int answer = 0;
    public int maxDepth(TreeNode root) {
        helper2(root, 0);
        return answer;
    }
    private void helper2(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            // 这个等于说是，做了个 方法体之外的变量，，
            answer = Math.max(answer, depth);
        }
        helper2(node.left, depth + 1);
        helper2(node.right, depth + 1);
    }

    // 使用 ，自下而上
    public int maxDepth1(TreeNode root) {

        return helper(root, 0);
    }

    private int helper(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(helper(node.left, depth + 1), helper(node.right, depth + 1));
    }
}
