package com.m2018.january;

import org.junit.Test;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * <p>
 * Created By a-mdx on 2018/1/9 上午10:42
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 好久没有做了，这道题说是在一个旋转 圆圈 排序后的数组中找到最小的那个值
 */
public class January09 {

    public int findMin(int[] nums) {
        // 应该可以 达到 O(log n) 的时间复杂度
//        int middle = nums.length/2;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 != end) {
            int middle = (start + end + 1) / 2;
            if (nums[start] > nums[middle]) {
                // 可能该区间有 最小值
                end = middle;
            } else if (nums[middle] > nums[end]) {
                //
                start = middle;
            } else {
                // 可能当前点就是最小点
                return nums[start];
            }
        }
        return Math.min(nums[start], nums[end]);
    }

    @Test
    public void test2() {
        int[] arr = {1, 2};
        System.out.println(findMin(arr));
    }

    @Test
    public void test1() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(arr));
    }

    public int findMin1(int[] nums) {
        // 这道题不应该会这么简单，这样的时间复杂度o(n),应该还有更简单的
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                return nums[i];
            }
        }
        return min;
    }


}
