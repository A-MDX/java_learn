package com.m2017.december;

import org.junit.Test;

/**
 * 52. N-Queens II
 * Follow up for N-Queens problem.
 * <p>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * Created by a-mdx on 2017/12/21.
 * https://leetcode.com/problems/n-queens-ii/description/
 * 额，做这道题，只是为了理解一些想法，对了，这道题刚开始想不出来，最后看别人的才能理解。
 */
public class December21 {

    int count;

    public int totalNQueens(int n) {

        boolean[] shuB = new boolean[n]; // | 竖线
        boolean[] leftB = new boolean[2 * n];  // \ 斜线，斜左上
        boolean[] rightB = new boolean[2 * n]; // / 斜线，斜右上

        genResult(0, shuB, leftB, rightB, n);

        return count;
    }

    private void genResult(int row, boolean[] shuB, boolean[] leftB, boolean[] rightB, int n) {
        if (row == n) {
            count++;
            return;
        }

        /*
        该方法原理，主要在于 控制那两条斜线
        首先 \ 这个斜线是 135度的斜线，其对应的数学函数是：y = -x + b，其中k 为-1；
        而 / 这个斜线是 45度的斜线，其对应的数学函数是：y = x + b， 其中k 为1。
        根据高中知识，如果某点在一条直线上，则其对应的 一次函数，其中的常量必然相同，
        即 \:b = x+y；  /:b=y-x 。
        根据大小猜测，我们将其范围控制在0 到 2n的范围内，则可涵盖所有斜线了：
        即 \:leftConstant = x+y；/:rightConstant = x-y+n
        col = x, row = y
         */

        for (int col = 0; col < n; col++) {
            int leftConstant = row + col; // 左常量
            int rightConstant = col - row + n;  // 右常量
            if (shuB[col] || leftB[leftConstant] || rightB[rightConstant]) {
                // 只要有一个命中，说明 相遇了
                continue;
            }
            shuB[col] = true;
            leftB[leftConstant] = true;
            rightB[rightConstant] = true;
            genResult(row + 1, shuB, leftB, rightB, n);

            // 回溯
            shuB[col] = false;
            leftB[leftConstant] = false;
            rightB[rightConstant] = false;
        }
    }

    @Test
    public void test1() {
        System.out.println(totalNQueens(8));
    }

}
