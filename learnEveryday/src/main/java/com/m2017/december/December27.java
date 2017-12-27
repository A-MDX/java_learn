package com.m2017.december;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * <p>
 * click to show follow up.
 * <p>
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * Created By a-mdx on 2017/12/27 上午10:29
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * 这道题似乎很简单，但是如果 考虑 时间 就难了
 * 看了别人的思想，这才叫编程嘛
 */
public class December27 {

    // 尝试使用 O(1) 的空间占用
    public void setZeroes(int[][] matrix) {
        // 看别人的想法

        boolean firstCol = false; // 第一列是否有 0 ？
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstCol = true;
            }
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // 这个思想是，将 上部 于 左边，即开头全部置 0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (firstCol) {
                // 若第一行有值，则 使用
                matrix[i][0] = 0;
            }
        }
    }

    // 这个 看着很简单，但是 其 占用的空间是 O(m+n)
    public void setZeroes1(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        // 横轴
        for (Integer row : rowSet) {
            Arrays.fill(matrix[row], 0);
        }
        // 纵轴
        for (Integer col : colSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

    }

    @Test
    public void test1() {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {1, 0, 4},
                {2, 5, 8}
        };
        setZeroes(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
