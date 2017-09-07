package com.m2017.september;

import org.junit.Test;

import java.util.Stack;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 * Created by a-mdx on 2017/9/6.
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * 寻找一个字符串中最长的回文子字符串
 * 似乎，使用 栈 ，会不会好一些？
 */
public class Sept06 {

    // 别人的方法，我的 140ms，别人的 26ms

    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = extend(s, i, i), s2 = extend(s, i, i + 1);
            if (s1.length() > max.length()) max = s1;
            if (s2.length() > max.length()) max = s2;
        }
        return max;
    }

    private String extend(String s, int i, int j) {
        for (; 0 <= i && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }

        return s.substring(i + 1, j);
    }

    // cao ，超时了。得想新方法。
    public String longestPalindrome1(String s) {

        if (s.length() == 1){
            return s;
        }

        String maxStr = s.substring(0, 1);

        char[] arr = s.toCharArray();
        char left2 = arr[0];
        char left1 = arr[1];

        if (left1 == left2){
            if (s.length() == 2){
                return s;
            }
            maxStr = new String(new char[]{left1, left2});
        }

        for (int i = 2; i < arr.length; i++) {
            char temp = arr[i];
            left1 = arr[i-1];
            left2 = arr[i-2];

            if (temp == left1){
                // 触发 bb 回文
                maxStr = bbHui(arr, i, maxStr);
                if (temp == left2){
                    // ... 处理  aaaxx 结构
                    maxStr = abaHui(arr, i, maxStr);
                }

            }else if (temp == left2){
                // 触发 aba 回文
                maxStr = abaHui(arr, i, maxStr);
            }

        }

        return maxStr;
    }

    private String bbHui(char[] arr, int i, String maxStr) {
        Stack<Character> stack = new Stack<>();
        stack.push(arr[i]);
        StringBuilder str = new StringBuilder();

        int left = i-1-1;
        int right = i+1;
        while (left >= 0 && right < arr.length){
            if (arr[left] == arr[right++]){
                stack.push(arr[left]);
                left--;
            }else {
                break;
            }

        }
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        String newStr = str.toString() + str.reverse();
        return newStr.length() > maxStr.length() ? newStr : maxStr;
    }

    private String abaHui(char[] arr, int i, String maxStr) {
        Stack<Character> stack = new Stack<>();
        char median = arr[i-1];

        stack.push(arr[i]);
        StringBuilder str = new StringBuilder();

        // c c c c ,处理i = 2时， 将 i=1 存储为 median，i存入
        int left = i-3;
        int right = i+1;
        while (left >= 0 && right < arr.length){
            if (arr[left] == arr[right]){
                stack.push(arr[left]);
                left--;
                right++;
            }else {
                break;
            }

        }
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        String newStr = str.toString();
        newStr = newStr+median + str.reverse() ;
        return newStr.length() > maxStr.length() ? newStr : maxStr;
    }

    @Test
    public void test1(){
        System.out.println(longestPalindrome("babad"));
    }


}

