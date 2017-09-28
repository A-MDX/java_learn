package com.m2017.september;

import org.junit.Test;

/**
 * Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * <p>
 * <p>
 * Created by a-mdx on 2017/9/28.
 * https://leetcode.com/problems/search-insert-position/description/
 * 自从买了个新电脑，我就很少写了
 */
public class Sept28 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > target){
                return i;
            }else if (num == target){
                return i;
            }
        }

        return nums.length;
    }

    @Test
    public void test1(){
        int[] arr = {1,3};
        System.out.println(searchInsert(arr, 2));
    }
}
