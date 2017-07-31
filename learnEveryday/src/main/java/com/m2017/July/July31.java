package com.m2017.July;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum Root to Leaf Numbers
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 * Created by a-mdx on 2017/7/31.
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 * 来道算法，这道题，似乎需要用到算法。
 * 这道题，未免太简单了
 */
public class July31 {

    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        SumTree(0, root, list);
        return list.stream().reduce((x, y) -> x+y).get();
    }

    private void SumTree(int num, TreeNode node, List<Integer> list){
        num = Integer.parseInt(num + "" + node.val);

        if (node.left == null && node.right == null){
            list.add(num);
            return;
        }

        if (node.left != null){
            SumTree(num, node.left, list);
        }

        if (node.right != null){
            SumTree(num, node.right, list);
        }

    }

    @Test
    public void test1(){
        System.out.println(Integer.valueOf("0"+1));
    }


    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

}
