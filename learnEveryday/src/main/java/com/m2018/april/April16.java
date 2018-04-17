package com.m2018.april;

import org.junit.Test;

/**
 * 342. 4的幂
 * 给定一个整数 (32位有符整数型)，请写出一个函数来检验它是否是4的幂。
 * <p>
 * 示例:
 * 当 num = 16 时 ，返回 true 。 当 num = 5时，返回 false。
 * <p>
 * 问题进阶：你能不使用循环/递归来解决这个问题吗？
 * Create by A-mdx at 2018-04-16 21:50
 * https://leetcode-cn.com/problems/power-of-four/description/
 */
public class April16 {

    public boolean isPowerOfFour(int num) {
        // 不使用递归的方式
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }
        while (num % 4 == 0) {
            num /= 4;
            if (num == 1) {
                return true;
            }
        }
        return false;

    }

    public boolean isPowerOfFour1(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }
        if (num % 4 == 0) {
            if ((num = num / 4) == 1) {
                return true;
            }
        } else {
            return false;
        }

        return isPowerOfFour(num);
    }

    @Test
    public void test1() {
        System.out.println(isPowerOfFour(17));
        System.out.println(8 << 1);
    }
}
