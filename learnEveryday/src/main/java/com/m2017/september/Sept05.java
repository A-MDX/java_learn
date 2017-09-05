package com.m2017.september;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 * Created by a-mdx on 2017/9/5.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * 这道题属于 高难度的 试试看
 */
public class Sept05 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        List<Integer> list = new ArrayList<>();

        int x1 = 0, x2 = 0;

        if (nums1.length == 0){
            while (nums2.length != x2){
                list.add(nums2[x2++]);
            }

            return findMedian(list);
        }
        if (nums2.length == 0){
            while (nums1.length != x1){
                list.add(nums1[x1++]);
            }

            return findMedian(list);
        }

        while (true){
            if (nums1[x1] < nums2[x2]){
                list.add(nums1[x1]);
                x1++;
            }else if (nums1[x1] > nums2[x2]){
                list.add(nums2[x2]);
                x2++;
            }else {
                list.add(nums1[x1]);
                list.add(nums1[x1]);
                x1++;
                x2++;
            }

            if (x1 == nums1.length && x2 == nums2.length){
                break;
            }

            if (x1 == nums1.length){
                while (x2 < nums2.length){
                    list.add(nums2[x2]);
                    x2++;
                }
                break;
            } else if (x2 == nums2.length){
                while (x1 < nums1.length){
                    list.add(nums1[x1]);
                    x1++;
                }
                break;
            }
        }

        return findMedian(list);

    }

    private double findMedian(List<Integer> list){
        int size = list.size();
        if (size == 0){
            return 0;
        }

        if (size % 2 != 0){
            return list.get(size/2);
        }else {
            int temp = size/2;
            return (list.get(temp) + list.get(temp-1))/2.0;
        }
    }

    @Test
    public void test2(){
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        int[] arr2 = {0,6};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    @Test
    public void test1(){
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
