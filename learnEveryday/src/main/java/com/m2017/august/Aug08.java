package com.m2017.august;

import org.junit.Test;

import java.util.Arrays;

/**
 * Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.
 * Created by a-mdx on 2017/8/8.
 * https://leetcode.com/problems/missing-number/description/
 */
public class Aug08 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1){
            int a = nums[0];
            if (a == 0){
                return 1;
            }else {
                return a-1;
            }
        }

        int a = nums[0];
        int index = 1;
        do {
            a++;
            if (a != nums[index++]){
                return a;
            }
        }while (index < nums.length);

        if (index == nums.length){
            if (nums[0] == 0){
                return nums[index-1]+1;
            }
            return nums[0]-1;
        }


        return 0;
    }

    @Test
    public void test1(){
        int[] arr = {1,2,4,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(missingNumber(arr));
    }
}
