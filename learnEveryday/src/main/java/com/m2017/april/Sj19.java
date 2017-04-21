package com.m2017.april;

import org.junit.Test;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Created by A-mdx on 2017/4/19.
 */
public class Sj19 {
    /*
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            int temp = nums[i];
//            if (temp > target){
//                continue;
//            }
            for (int j = i+1; j < nums.length; j++) {
                int temp2 = nums[j];
//                if (temp2 > target){
//                    continue;
//                }
                if (target == temp+temp2){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    
    @Test
    public void test1(){
        int[] arr = new int[]{3,2,-3};
        arr = twoSum(arr, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
