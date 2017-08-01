package com.m2017.august;

import org.junit.Test;

/**
 * Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Created by a-mdx on 2017/8/1.
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 * 今天想做两道简单的题, 这道题恶心的一点也不简单
 */
public class Aug01C {
    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0){
            // 难点在于没有 0 ，从1 开始的

            n--;

            int res = n % 26;

            s.insert(0, (char) ('A' + res));

            n = n/26;
        }
//        s = (char)('A' + n - 1) + s;
        return s.toString();
    }

    @Test
    public void test1(){
        System.out.println(convertToTitle(1));
    }
}
