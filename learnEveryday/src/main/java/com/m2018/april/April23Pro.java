package com.m2018.april;

import org.junit.Test;

import java.util.*;

/**
 * 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * Create by A-mdx at 2018-04-23 22:22
 * 这道题 一颗赛艇
 */
public class April23Pro {

    // 使用别人的 方法
    // 虽说一眼看着不太清楚，但真简单
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ints = new ArrayList<>();
        diff(root, 0, ints);
        return ints;
    }

    private void diff(TreeNode node, int index, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (index >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(index).add(node.val);
        diff(node.left, index + 1, result);
        diff(node.right, index + 1, result);
    }

    // 自己写的，似乎有些臃肿。。
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ints = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
            helper(queue, ints);
        }
        return ints;
    }

    private void helper(Queue<TreeNode> oldQueue, List<List<Integer>> ints) {
        if (oldQueue.isEmpty()) {
            return;
        }
        Queue<TreeNode> newQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (!oldQueue.isEmpty()) {
            TreeNode node = oldQueue.poll();
            list.add(node.val);
            if (node.left != null) {
                newQueue.offer(node.left);
            }
            if (node.right != null) {
                newQueue.offer(node.right);
            }
        }
        ints.add(list);
        helper(newQueue, ints);
    }

    @Test
    public void test1() {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(levelOrder(node));

    }
}
