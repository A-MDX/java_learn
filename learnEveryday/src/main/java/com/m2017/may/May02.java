package com.m2017.may;

import org.junit.Test;

/**
 * Given an integer, return its base 7 string representation.

 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].
 * Created by A-mdx on 2017/5/2.
 * <url>https://leetcode.com/problems/base-7/#/description</url>
 * 7 进制，将10进制转化为7进制。
 */
public class May02 {
    public String convertToBase7(int num) {
        StringBuilder str = new StringBuilder();
        if (num < 0){
            str.append("-");
            num *= -1;
        }
        addStrNum(num, str);
        
        return str.toString();
    }
    
    public void addStrNum(int num, StringBuilder str){
        int temp = num%7;
        if (num >= 7){
            num /= 7;
            addStrNum(num, str);
        }
        str.append(temp);
        
    }
    
    @Test
    public void test1(){
        System.out.println(convertToBase7(-7));
    }
    
}
