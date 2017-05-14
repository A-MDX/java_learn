package com.m2017.may;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * Created by A-mdx on 2017/5/14.
 * https://leetcode.com/problems/contains-duplicate/#/description
 * 查看是否是含有重复的。就当是练手吧。
 */
public class May14 {

    public boolean containsDuplicate(int[] nums) {
        boolean has = false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }

        return has;
    }
}
