package com.m2017.june;

import org.junit.Test;

/**
 * Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that num[-1] = num[n] = -∞.
 * <p>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * Created by A-mdx on 2017/6/22.
 * https://leetcode.com/problems/find-peak-element/#/description
 * 这个中等难度的，未免太简单了点。
 */
public class June22 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = 1;
        if (nums.length == 1) {
            return left;
        }
        if (nums[left] > nums[right]) {
            return left;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            left = i - 1;
            right = i + 1;
            int num = nums[i];
            if (nums[left] < num && nums[right] < num) {
                return i;
            }
        }

        return right;
    }

    @Test
    public void test1() {
        int[] arr = {4, 3, 2, 1};
        System.out.println(findPeakElement(arr));
    }

}
