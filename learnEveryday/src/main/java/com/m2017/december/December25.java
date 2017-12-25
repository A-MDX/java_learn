package com.m2017.december;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 62. Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * Created by a-mdx on 2017/12/25.
 * https://leetcode.com/problems/unique-paths/description/
 * 机器人走路，可以向下，可以向右，一次只能走一步。从左上角 到 右下角，总共多少种走法？
 * 这道题应该属于 dp 问题，中等难度，对我来说可能就有点难了。
 * 仔细想好后，代码不是很多，但是可能前期理解有点难。 漫画算法：动态规划
 * 与这个相结合就比较好理解了
 */
public class December25 {

    /*
    1. 最优子结构：f(m,n) = f(m-1,n)+f(m,n-1)
    2. 边界：f(0,1) = 1, f(1,0) = 1, f(m, 0) = 1, f(0, n) = 1
    3. 状态转移公式 ：f(m,n) = f(m-1,n)+f(m,n-1)
     */

    /*
    看别人的方法，关于这个，猜测为：
    因为其本身是对称的，对称线 为 左上角 至 右下角，
    因此 完全没有必要整出 重复性运算：
    arr[j] += arr[j-1] 在此时，arr[j] 为 其上方的数字，arr[j-1]为 其 左边的数字。
    这样一加，天，真是简单。厉害了
     */
    public int uniquePaths(int m, int n) {
        // 使用 1d 数组
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[j] += arr[j - 1];
            }
        }
        return arr[n - 1];
    }

    /**
     * 感觉 ，这个 细想之下，将一个 简单的抽象问题，处理成了 一个 跟 图片一样的问题
     * 这样算下来，真是神奇
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths4(int m, int n) {
        // 如何做成 真 DP 呢
        // 看过别人的答案后，似乎，可以用 一个 2d 数组搞定
        int[][] arr = new int[m][n];

        // 初始化边界条件
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }

        // 开始 处理 dp 问题，类似，画excel
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int uniquePaths2(int m, int n) {
        // 这个方程 还不够 dp，属于升级版，牺牲 空间
        if (n == 1) {
            return 1;
        }
        if (m == 1) {
            return 1;
        }
        int tempKey = m * 113 + n * 117;
        if (map.containsKey(tempKey)) {
            return map.get(tempKey);
        }
        int result = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        map.put(tempKey, result);
        return result;
    }


    public int uniquePaths1(int m, int n) {
        // 这个方程 还不够 dp，由于重复性计算太多，其 效率 太低
        if (n == 1) {
            return 1;
        }
        if (m == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }

    @Test
    public void test1() {
        System.out.println(uniquePaths(3, 3));
    }

}
