package com.m2017.june;

import org.junit.Test;

/**
 * House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Created by A-mdx on 2017/6/28.
 * https://leetcode.com/problems/house-robber/#/description
 * 简单说，寻找最优解，在给定的数列中，找到最佳路线
 * 哎呀，还是人家的算法比较厉害，我感觉我怎么也想不到这种厉害的算法了。
 */
public class June28 {
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int robYes = 0;
        int robNo = 0;
        for (int i : nums) {
            int temp = robNo;
            robNo = Math.max(robYes, robNo);
            robYes = i + temp;
        }
        
        return Math.max(robYes, robNo);
        
    }
    
    @Test
    public void test1(){
        int[] arr = {4,2,3,5,7,9,8,1,5};
        int max = rob(arr);
        System.out.println(max);
    }
    
}
