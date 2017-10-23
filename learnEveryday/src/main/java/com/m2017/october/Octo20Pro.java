package com.m2017.october;

import org.junit.Test;

/**
 * 101. Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * Created by a-mdx on 2017/10/20.
 * https://leetcode.com/problems/symmetric-tree/description/
 * 关于 验证这棵树是否是对称的。
 * 初看有点难，写了感觉还挺简单的
 */
public class Octo20Pro {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return valid(root.left, root.right);
    }

    public boolean valid(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return valid(left.left, right.right) && valid(left.right, right.left);
    }

    @Test
    public void test1(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(5);
        right.left = new TreeNode(7);
        right.right = new TreeNode(3);
        root.right = right;
        root.left = left;
        System.out.println(isSymmetric(root));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
