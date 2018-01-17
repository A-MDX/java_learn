package com.m2018.january;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * return
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * Created By a-mdx on 2018/1/17 上午10:38
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class January17 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(result, new ArrayList<>(), root, sum, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, ArrayList<Integer> integers, TreeNode node, int sum, int nowNum) {
        integers.add(node.val);
        nowNum += node.val;
        if (node.left != null) {
            helper(result, integers, node.left, sum, nowNum);
        }
        if (node.right != null) {
            helper(result, integers, node.right, sum, nowNum);
        }
        if (nowNum == sum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(integers));
        }
        integers.remove(integers.size() - 1);
    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);
        root.right = right;
        root.left = left;

        TreeNode left1 = new TreeNode(11);
        left1.left = new TreeNode(7);
        left1.right = new TreeNode(2);
        left.left = left1;

        TreeNode rightLeft1 = new TreeNode(13);
        TreeNode right1 = new TreeNode(4);
        right.left = rightLeft1;
        right.right = right1;

        right1.left = new TreeNode(5);
        right1.right = new TreeNode(1);


        pathSum(root, 22).forEach(System.out::println);
    }

}
