package com.m2017.august;

import org.junit.Test;

/**
 * Excel Sheet Column Number
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * Created by a-mdx on 2017/8/1.
 * https://leetcode.com/problems/excel-sheet-column-number/description/
 * 这道题，试试看吧
 */
public class Aug01 {
    public int titleToNumber(String s) {
        char[] arr = s.toCharArray();
        int num = 0;
        int temp = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            num += (arr[i] - 'A' + 1) * (Math.pow(26, temp));
            temp++;
        }
        return num;
    }

    public int titleToNumber2(String s) {
        char[] arr = s.toCharArray();
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num = num * 26 + (arr[i] - 'A' + 1);
        }
        return num;
    }

    @Test
    public void test1(){
        System.out.println(titleToNumber("AB"));
    }
}
