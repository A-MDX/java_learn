package com.m2017.July;

/**
 * Maximum Subarray
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * Created by A-mdx on 2017/7/4.
 * https://leetcode.com/problems/maximum-subarray/#/description
 * 感觉好久没做了，这个不能停呀
 * 哎，复习一下别人的dp解法吧， 动态规划，哎。。
 */
public class July04 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int max = arr[0];
        // 这个动态规划简直太神奇了。
        for (int i = 1; i < n; i++) {
            arr[i] = nums[i] + (arr[i - 1] > 0 ? arr[i - 1] : 0);
            max = Math.max(max, arr[i]);
        }
        return max;
    }


}
