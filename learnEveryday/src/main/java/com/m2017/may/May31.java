package com.m2017.may;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * Created by A-mdx on 2017/5/31.
 * https://leetcode.com/problems/intersection-of-two-arrays/#/description
 * 给两个数组，求共有的数组
 */
public class May31 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] arr = new int[set2.size()];
        int index = 0;
        for (Integer integer : set2) {
            arr[index] = integer;
            index++;
        }
        return arr;
    }

    @Test
    public void test1() {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        int[] arr = intersection(arr1, arr2);
        System.out.println(Arrays.toString(arr));
    }
}
