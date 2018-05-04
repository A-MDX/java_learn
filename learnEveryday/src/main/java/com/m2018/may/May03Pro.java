package com.m2018.may;

import org.junit.Test;

/**
 * 643. 子数组最大平均数 I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * Create by A-mdx at 2018-05-03 22:57
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/description/
 * 这道题，似乎在哪见过
 */
public class May03Pro {

    // 这样就好多了
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max, sum);
        }
        // 原来还能将结果在最后一步 给出来，啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
        return max / k;
    }

    // 方法有问题，太慢了，
    public double findMaxAverage1(int[] nums, int k) {
        if (nums.length == k) {
            double sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            sum /= k;
            return sum;
        }

        double max = Double.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            double sum = 0;
            for (int j = 0; j <= k; j++) {
                sum += nums[i + j];
            }
            sum /= k;
            max = Math.max(max, sum);
        }
        return max;
    }


    @Test
    public void test1() {
        int[] arr = {-1};
        System.out.println(arr.length);
        System.out.println(findMaxAverage(arr, 1));

    }

    @Test
    public void name() {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
