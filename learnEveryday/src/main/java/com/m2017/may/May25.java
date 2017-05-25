package com.m2017.may;

import org.junit.Test;

/**
 * Invert a binary tree.
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 * <p>
 * Created by A-mdx on 2017/5/25.
 * https://leetcode.com/problems/invert-binary-tree/#/description
 * 
 * 时间还早，在写一道简单的二叉树，就当作是复习了。我还构建了一棵树。。
 */
public class May25 {

    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            translate(root);
        }
        return root;
    }
    
    public void translate(TreeNode node){
        
        if (node.left == null && node.right == null){
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.right != null){
            translate(node.right);
        }
        if (node.left != null){
            translate(node.left);
        }
    }
    
    @Test
    public void test1(){
        int[] arr = {5,1,9,6,7,3,4,2,8};
        TreeNode root = new TreeNode(5);
        for (int i = 0; i < arr.length; i++) {
            root.insert(arr[i]);
        }
        printTree(root, 1);
    }
    
    public void printTree(TreeNode node, int index){
        if (node != null){
            System.out.println(index +" : "+node.val);
        }
        if (node.left != null){
            printTree(node.left, index+1);
        }
        if (node.right != null){
            printTree(node.right, index+1);
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public static class TreeNode{
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x){
           val = x;
       }
       public void insert(int num){
           if (num > val){
               if (right != null){
                   right.insert(num);
               }else {
                   TreeNode temp = new TreeNode(num);
                   right = temp;
               }
               
           }else if (num < val){
               if (left != null){
                   left.insert(num);
               }else {
                   TreeNode temp = new TreeNode(num);
                   left = temp;
               }
           }else {
               
           }
       }
    }
}
