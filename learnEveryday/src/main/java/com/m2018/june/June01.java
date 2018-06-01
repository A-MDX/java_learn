package com.m2018.june;

import org.junit.Test;

import java.util.Arrays;

/**
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 * Create by A-mdx at 2018-05-31 23:35
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 * 昨天没有完成，今天继续
 * 说是简单难度，结果整的这么恶心。
 */
public class June01 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        Count count = new Count();
        count.max = nums[0];
        count.maxSize = 1;
        int maxLength = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num - count.max > 1) {
                if (count.hasMin) {
                    maxLength = Math.max(count.maxSize + count.minSize, maxLength);
                }
                count.hasMin = false;
                count.minSize = 0;
                count.max = num;
                count.maxSize = 1;
                continue;
            } else if (num - count.max == 1) {
                count.hasMin = true;
                maxLength = Math.max(count.maxSize + count.minSize, maxLength);
                count.minSize = count.maxSize;
                count.max = num;
                count.maxSize = 1;
                continue;
            }
            // 相等
            count.maxSize++;
        }
        if (count.hasMin) {
            maxLength = Math.max(count.maxSize + count.minSize, maxLength);

        }
        return maxLength;
    }

    private static class Count {
        boolean hasMin = false;
        int max;
        int minSize;
        int maxSize;
    }

    @Test
    public void rrwar1() {
        int[] arr = {2, 5, 5, 5};
        System.out.println(findLHS(arr));
    }

    @Test
    public void test1() {
        int[] arr = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(findLHS(arr));
    }
}
