package com.m2018.january;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5
 * Created By a-mdx on 2018/1/16 下午5:52
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class January16Plus {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int lIndex, int rIndex) {
        if (lIndex > rIndex) {
            return null;
        }
        int mid = (rIndex - lIndex) / 2 + lIndex;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, 0, mid - 1);
        node.right = helper(nums, mid + 1, rIndex);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int num) {
        val = num;
    }
}