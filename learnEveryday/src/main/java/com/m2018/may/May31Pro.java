package com.m2018.may;

import org.junit.Test;

import java.util.Arrays;

/**
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 * Create by A-mdx at 2018-05-31 23:35
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 * 
 */
public class May31Pro {
    public int findLHS(int[] nums) {
        int max = 0;
        int size = 1;
        Arrays.sort(nums);
        int big = nums[0];
        int small = nums[0];
        int changeIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            if (small == big){
                if (now - big > 1){
                    big = now; 
                    small = now;
                    size = 1;
                    continue;
                }else {
                    
                    size++;
                    small = big;
                    big = Math.max(big, now);
                }
            }else {
                
            }
            if (now - big > 1){
                big = Math.max(big, now);
                small = Math.min(small, now);
                size++;
            }else if (now - big == 1){
//                changeIndex = i;
                
            }
            
            if (Math.abs(now-big) > 1 || Math.abs(now- small) > 1){
                max = Math.max(size, max);
                size = 0;
                big = now;
                small = now;
                continue;
            }
            if (now - small == 1){
                changeIndex = i;
            }
            big = Math.max(big, now);
            small = Math.min(small, now);
            size++;
        }
        max = Math.max(size, max);
        return max;
    }
    
    @Test
    public void test1(){
        int[] arr = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(arr));
    }

    @Test
    public void rrwar1() {
        int[] arr = {1,2,3,4};
        System.out.println(findLHS(arr));
    }
}
