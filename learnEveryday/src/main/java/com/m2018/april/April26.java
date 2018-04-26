package com.m2018.april;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * Create by A-mdx at 2018-04-26 21:53
 * 为何，今天有些累了。
 */
public class April26 {

    /**
     * 看了别人的做法，额，要用 队列。。。。
     * 才能用迭代的方式完成
     * 天，这个方法真的绝了，应该是对 数据结构有过深刻理解才能想出来了。。。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

    /**
     * 似乎目前只会递归的形式来完成
     * 若是迭代的话，怎么做，是不是要用到 栈？
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        check(root.left, root.right);
        return isSymme;
    }

    boolean isSymme = true;

    private void check(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val != right.val) {
                isSymme = false;
                return;
            }
        } else {
            if (left != null || right != null) {
                isSymme = false;
                return;
            }
            return;
        }

        check(left.left, right.right);
        check(left.right, right.left);
    }

}
