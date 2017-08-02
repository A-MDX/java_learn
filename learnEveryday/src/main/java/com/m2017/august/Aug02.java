package com.m2017.august;

import org.junit.Test;

import java.util.Arrays;

/**
 * Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * Created by a-mdx on 2017/8/2.
 * https://leetcode.com/problems/move-zeroes/description/
 * 把所有的 0 都移动到最后，简单的题
 */
public class Aug02 {
    public void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                arr[size++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test1(){
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
