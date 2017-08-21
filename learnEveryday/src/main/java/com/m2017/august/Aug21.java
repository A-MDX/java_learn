package com.m2017.august;

import org.junit.Test;

import java.util.*;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 * Created by a-mdx on 2017/8/21.
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 好久没写了，这道题，看着需要很基础的算法逻辑
 */
public class Aug21 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            if (!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int size = nums.length;
        List<Integer> list = new ArrayList<>();

        // 还有这种操作。。。
        boolean[] arr = new boolean[size+1];
        for (int num : nums) {
            arr[num] = true;
        }
        for (int i = 1; i < size+1; i++) {
            if (!arr[i]){
                list.add(i);
            }
        }
        return list;
    }

    @Test
    public void test1(){
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers2(arr));
    }

    @Test
    public void ts() throws Exception {
        // int[] 没法转成 List<Integer>...
        // 基本类型，，，

        Integer[] arr = {4,3,2,7,8,2,3,1};
        List list = Arrays.asList(arr);
        System.out.println(list);
    }
}
