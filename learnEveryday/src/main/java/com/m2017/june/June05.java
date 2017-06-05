package com.m2017.june;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Shuffle an Array
 * Shuffle a set of numbers without duplicates.

 Example:

 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();
 * Created by A-mdx on 2017/6/5.
 * https://leetcode.com/problems/shuffle-an-array/#/description
 */
public class June05 {


    public static void main(String[] args) {
        Solution  solution = new Solution(new int[]{1,2,3});
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}

class Solution {

    int[] origin;

    public Solution(int[] nums) {
        origin = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (origin == null) {
            return null;
        }
        int length = origin.length;
        int[] arr = new int[length];
        Random rand = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int a = rand.nextInt(length);
            if (set.contains(a)) {
                i--;
                continue;
            }
            arr[i] = origin[a];
            set.add(a);
        }

        return arr;
    }
}