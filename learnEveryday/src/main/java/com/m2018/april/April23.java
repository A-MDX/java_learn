package com.m2018.april;

import org.junit.Test;

import java.util.*;

/**
 * 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]  
 *    1
 *     \
 *      2
 *     /
 *    3 
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * Create by A-mdx at 2018-04-23 21:05
 */
public class April23 {

    // 后序遍历，
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode node = root;
        if (root != null) {
            stack.add(root);
        }
        while (!stack.isEmpty()){
            if (node.left != null && !set.contains(node.left)){
                stack.push(node);
                node = node.left;
                continue;
            }
            if (node.right != null && !set.contains(node.right)){
                stack.push(node);
                node = node.right;
                continue;
            }
            list.add(node.val);
            set.add(node);
            node = stack.pop();
        }
        return list;
    }
    
    @Test
    public void test1(){
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(node));
        
    }
    
    // 先使用 递归试试
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            helper(root, list);
        }
        return list;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            helper(node.left, list);
        }
        if (node.right != null) {
            helper(node.right, list);
        }
        list.add(node.val);
    }

}
