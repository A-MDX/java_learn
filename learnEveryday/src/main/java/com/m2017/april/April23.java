package com.m2017.april;

import org.junit.Test;

import java.util.Arrays;

/**
 * Total Accepted: 121614
 * Total Submissions: 395322
 * Difficulty: Medium
 * Contributor: LeetCode
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Created by A-mdx on 2017/4/23.
 * 这是吸收昨天的知识。
 */
public class April23 {
    public int threeSumClosest(int[] nums, int target) {
        int close = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            
            int sum = target-nums[i];
            int low = i+1;
            int height = nums.length-1;
            while(height > low){
                // temp,close 代表间距
                int temp =nums[low]+nums[height]- sum;
                if (Math.abs(close) > Math.abs(temp)){
                    close = temp;
                }

                if (close == 0){
                    return target;
                }
                // 所查数值需更进一步分析
                if (temp > 0){
                    // 若为正，则减小temp值
                    height--;
                }else {
                    // 若为负，则增加temp值
                    low++;
                }
               
            }
        }
        
        return close+target;
    }
    
    @Test
    public void test1(){
        int[] arr = new int[]{0,2,1,-3};
        System.out.println("threeSumClosest(arr, 1);"+threeSumClosest(arr, 1));
        
    }
}
