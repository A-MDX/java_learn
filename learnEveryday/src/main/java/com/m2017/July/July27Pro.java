package com.m2017.July;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Single Number II
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Created by a-mdx on 2017/7/27.
 * https://leetcode.com/problems/single-number-ii/tabs/description
 * 每个数字三次，查找出现一次的？
 */
public class July27Pro {
    public int singleNumber(int[] nums) {
        // 试试  ^= ?
        final int[] num = {0};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else {
                map.put(i, 1);
            }
        }

        map.forEach((k, v) -> {
            if (v == 1){
                num[0] = k;
            }
        });

        return num[0];
    }

    @Test
    public void test1(){
        int[] arr = {2, 2,2, 1};
        System.out.println(singleNumber(arr));
    }
}
