package com.m2017.July;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 线性复杂度，不要额外的内存消耗
 * Created by a-mdx on 2017/7/27.
 * https://leetcode.com/problems/single-number/tabs/description
 * 寻找单身狗， 以前写过的，但是没有通过他们的测试，还是重新写。
 */
public class July27 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if (set.contains(num)){
                set.remove(num);
            }else {
                set.add(num);
            }

        }
        return set.iterator().next();
    }

    // 这个方法丧心病狂，我第一次见 还有这种玩法，
    public int singleNumber2(int[] nums) {
        int ans = 0;
        if(nums.length != 0) {
            for(int num: nums) {
                ans ^= num;
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        int[] arr = {2, 2, 1};
        System.out.println(singleNumber(arr));
    }
}
