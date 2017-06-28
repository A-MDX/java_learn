package com.m2017.june;

import org.junit.Test;

/**
 * Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 * <p>
 * Consider the following matrix:
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * <p>
 * Given target = 20, return false.
 * Created by A-mdx on 2017/6/27.
 * https://leetcode.com/problems/search-a-2d-matrix-ii/#/description
 * 难得过来刷道题
 */
public class June27 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length ==0 || matrix[0].length == 0){
            return false;
        }
        final int x = matrix.length;
        final int y = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[x - 1][y - 1];
        if (target < min || target > max) {
            return false;
        }

        int x1 = 0;
        int y1 = matrix[0].length - 1;
        while (y1 >= 0 && x1 <= matrix.length - 1) {
            int num = matrix[x1][y1];
            if (target == num) {
                return true;
            } else if (target > num) {
                x1++;
            } else {
                y1--;
            }
        }

        return false;

    }

    @Test
    public void test1() {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(matrix, 14));
    }

}
