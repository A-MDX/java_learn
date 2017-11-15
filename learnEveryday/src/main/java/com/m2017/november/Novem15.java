package com.m2017.november;

import org.junit.Test;

import java.util.Map;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is
 * that adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Created by a-mdx on 2017/11/15.
 * https://leetcode.com/problems/house-robber/description/
 * 这道题 ，应该是 dp problem ...
 */
public class Novem15 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        // F(n) = max(F(n-1), F(n-2))   // 最优子结构
        // F(n-1) = max(F(n-3), F(n-4))  //  状态转换方程1
        // F(n-2) = max(F(n-4), F(n-5))   // 状态转换方程2...
        // F(1) = nums[0];  // 边界
        // F(2) = max(nums[1], F(1));
        // F(3) = max(F(1)+nums[2], F(2))
        // F(4) = max( (max(F(1),F(2)) + nums[3]) , F(3))

        // 1.直接 递归
//        return Math.max(findMax(nums, length-1), findMax(nums, length-2));

        // 2.备忘录算法
//        Map<Integer, Integer> map = new HashMap<>();
//        return Math.max(findMax(nums, length-1, map), findMax(nums, length-2, map));

        // 3.真-DP  ...
        return findDp(nums);
    }


    // 备忘录算法，空间换时间，依旧不 dp
    public int findMax(int[] arr, int index, Map<Integer, Integer> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (index == 0) {
            map.put(index, arr[index]);
            return arr[index];
        }
        if (index == 1) {
            map.put(index, arr[index]);
            return arr[index];
        }
        if (index == 2) {
            int result = arr[index] + arr[0];
            map.put(index, result);
            return result;
        }
        if (index == 3) {
            int result = arr[index] + Math.max(arr[0], arr[1]);
            map.put(index, result);
            return result;
        }
        int result = arr[index] + Math.max(findMax(arr, index - 2, map), findMax(arr, index - 3, map));
        map.put(index, result);
        return result;
    }

    // 使用递归的方式，这不dp
    public int findMax(int[] arr, int index) {
        if (index == 0) {
            return arr[index];
        }
        if (index == 1) {
            return arr[index];
        }
        if (index == 2) {
            return arr[index] + arr[0];
        }
        if (index == 3) {
            return arr[index] + Math.max(arr[0], arr[1]);
        }

        return arr[index] + Math.max(findMax(arr, index - 2), findMax(arr, index - 3));
    }

    // 真 dp
    public int findDp(int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return arr[0];
        }
        if (length == 2) {
            return arr[1];
        }

        // a,b,c,d 分别对应4个动态下标

        int a = arr[0];
        int b = arr[1];
        if (length == 3) {
            return Math.max(a + arr[2], b);
        }
        int c = Math.max(a + arr[2], b);

        int d = arr[3] + Math.max(a, b);

        for (int i = 4; i < arr.length; i++) {
            // 每次i+i等于 a,b,c,d 向右移动一次。
            a = b;
            b = c;
            c = d;
            d = arr[i] + Math.max(a, b);

        }
        return Math.max(c, d);
    }

    @Test
    public void test1() {
        int[] arr = {2, 1, 1, 2};
        System.out.println(rob(arr));
    }

    @Test
    public void test12() {
        int[] arr = {3, 5, 3, 4, 8, 4};
        System.out.println(findDp(arr));
    }
}
