package com.m2017.July;

import org.junit.Test;

import java.util.Arrays;

/**
 * Spiral Matrix II
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * For example,
 * Given n = 3,
 * <p>
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * Created by a-mdx on 2017/7/14.
 * https://leetcode.com/problems/spiral-matrix-ii/#/description
 * 哈，这个就是螺旋输出一个数组，以前写过的
 * 这个真是涨自信，哈哈哈
 */
public class July14 {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        trans(arr, 1, 0, n - 1, 0, n - 1, n);

        return arr;
    }

    public void trans(int[][] arr, int index, int left, int right, int height, int low, int n) {
        if (index > n * n) {
            return;
        }
        // 左 -》 右
        for (int i = left; i <= right; i++) {
            arr[height][i] = index++;
        }
        height++;

        // 右 -》 下
        for (int i = height; i <= low; i++) {
            arr[i][right] = index++;
        }
        right--;

        // 右 -》 左
        for (int i = right; i >= left; i--) {
            arr[low][i] = index++;
        }
        low--;

        // 下 -》 上
        for (int i = low; i >= height; i--) {
            arr[i][left] = index++;
        }
        left++;
        trans(arr, index, left, right, height, low, n);
    }


    @Test
    public void test1() {
        int[][] arr = generateMatrix(4);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));

        }
    }

}
