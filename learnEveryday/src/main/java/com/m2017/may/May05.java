package com.m2017.may;

import org.junit.Test;

/**
 * Happy Number
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number
 * <p>
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Created by A-mdx on 2017/5/6.
 * https://leetcode.com/problems/happy-number/#/description
 * 有意思，绝对要递归了。
 */
public class May05 {
    public boolean isHappy(int n) {
        int i = findHappy(n, 0);
        if (i == 1) {
            return true;
        }
        return false;
    }

    public int findHappy(int n, int i) {
        if (i > 10) {
            return n;
        }
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return findHappy(sum, i + 1);
    }

    @Test
    public void test1() {
        System.out.println(isHappy(7));
    }
}
