package com.m2018.april;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Create by A-mdx at 2018-04-22 22:04
 * 使用中序遍历，额，先常规 的 递归试试
 */
public class April22 {

    // 这次使用 迭代的方式，可能需要想想
    // 自己愣是没有想出来
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                // 天，这个方法，简直太机智了。
                node = node.right;
            }
        }

        return list;
    }

    // 这个应该就是中序排序了吧
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            helper(root, list);
        }
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node.left == null) {
            list.add(node.val);
        } else {
            helper(node.left, list);
            // 回来之后，得将当前值加入进去
            list.add(node.val);
        }
        if (node.right != null) {
            helper(node.right, list);
        }

    }

}
