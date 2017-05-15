package com.m2017.may;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * Total Accepted: 105965
 * Total Submissions: 331153
 * Difficulty: Easy
 * Contributor: LeetCode
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * Created by A-mdx on 2017/5/15.
 * https://leetcode.com/problems/contains-duplicate-ii/#/description
 * 这个，也是找多余的数，似乎挺简单呀。
 */
public class May15 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index1 = map.get(nums[i]);
                if (i - index1 <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }

    @Test
    public void test1() {
        int[] arr = {1, 2};
        System.out.println(containsNearbyDuplicate(arr, 2));
    }
}
