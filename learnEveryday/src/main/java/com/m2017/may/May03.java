package com.m2017.may;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 * Created by A-mdx on 2017/5/3.
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/#/description
 * 找数字，找到两个不同的
 * 
 */
public class May03 {
    public int[] twoSum(int[] numbers, int target) {
        // 这个算法，感觉是个 O(log N) 的，似乎是吸取了目前看的数据结构与方法的 思想。
        int a = 0;
        int b = numbers.length-1;
        int sum;
        while (a < b){
            sum = numbers[a] + numbers[b];
            if (sum > target){
                b--;
            }else if (sum < target){
                a++;
            }else {
                return new int[]{a+1,b+1};
            }
        }
        return null;
    }
    
    @Test
    public void test1(){
        int[] arr = {1,7,2,11};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(twoSum(arr,9)));
        
    }
}
