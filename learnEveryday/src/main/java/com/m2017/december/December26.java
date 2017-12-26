package com.m2017.december;

import org.junit.Test;

import java.util.Arrays;

/**
 * 63. Unique Paths II
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * <p>
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p>
 * Note: m and n will be at most 100.
 * Created By a-mdx on 2017/12/26 下午4:48
 * https://leetcode.com/problems/unique-paths-ii/description/
 * 这个接着 昨天的，似乎有点难
 */
public class December26 {

    @Test
    public void test1() {
        int[][] arr = new int[][]{
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(arr));
    }

    // 应该还是使用 dp
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];

        // 1. 状态 转换方程 m,n
        // f(arr[m][n]) = f(arr[m][n-1]) + f(arr[m-1][n-1]

        // 2. 边界
        // arr[m][0] = 1, arr[0][n] = 1

        // init
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                // 非障碍
                arr[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                arr[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // 障碍，则 停下，
                    continue;
                }
                // 一个上面，一个 右边
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        return arr[m - 1][n - 1];
    }
}
