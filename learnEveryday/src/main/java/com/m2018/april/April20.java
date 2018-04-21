package com.m2018.april;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 学习二叉树，前序遍历
 * 给定一棵二叉树，返回其节点值的前序遍历。
 * <p>
 * 例如：
 * 给定二叉树[1,null,2,3]，
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * 返回 [1,2,3]。
 * <p>
 * 注意: 递归方法很简单，你可以使用迭代方法来解决吗？
 * Create by A-mdx at 2018-04-20 22:45
 */
public class April20 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // 若是不用递归，得用栈啊。
        // 别人的想法，也是厉害了
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root != null && !stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(root.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 还是用了递归
        if (root == null) {
            return list;
        }
        helper2(root, list);
        return list;
    }

    private void helper2(TreeNode node, List<Integer> list) {
        list.add(node.val);
        if (node.left != null) {
            helper2(node.left, list);
        }
        if (node.right != null) {
            helper2(node.right, list);
        }
    }

    // 这个不叫前序遍历
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            helper(root, list);
        }
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        if (node.left != null) {
            helper(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            helper(node.right, list);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}