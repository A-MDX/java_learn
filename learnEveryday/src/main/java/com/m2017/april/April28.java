package com.m2017.april;

import org.junit.Test;

import java.util.Arrays;

/**
 * Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Created by A-mdx on 2017/4/28.
 * https://leetcode.com/problems/single-number/#/description
 * 查找单身狗，然后不要消耗过多时间，过多空间。
 */
public class April28 {
	public int singleNumber(int[] nums) {
		
		Arrays.sort(nums);
		int num = nums[0];
		boolean next = true;
//		if (nums.length == 1){
//			return num;
//		}
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] ==num){
				next = true;
			}else {
				if (!next){
					return num;
				}
				next = false;
			}
			num = nums[i];
		}
		return num;
	}
	
	@Test
	public void test1(){
		int[] arr = {1,11,22,22,1,7,7,6,3,3,6,11,9};
		System.out.println(singleNumber(arr));
	}

	@Test
	public void test2(){
		int[] arr = {1};
		System.out.println(singleNumber(arr));
	}
}
