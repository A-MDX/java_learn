package com.m2018.january;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p>
 * Created By a-mdx on 2018/1/9 上午11:28
 * https://leetcode.com/problems/majority-element/description/
 * 这个应该属于找到最多的元素
 */
public class January09Plus {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.computeIfPresent(i, (k, v) -> ++v);
            map.putIfAbsent(i, 1);
        }
        final int[] maxKey = {0};
        final int[] maxVal = {0};
        map.forEach((k, v) -> {
            if (v > maxVal[0]) {
                maxKey[0] = k;
                maxVal[0] = v;
            }
        });
        return maxKey[0];
    }

    @Test
    public void test1() {
        int[] arr = {1,2,3,4,3,3,3,5,4,3,1,2,4};
        System.out.println(majorityElement(arr));
    }
}
