package com.m2017.november;

import org.junit.Test;

import java.util.*;

/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * <p>
 * Given "foo", "bar", return false.
 * <p>
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 * Created by a-mdx on 2017/11/7.
 * https://leetcode.com/problems/isomorphic-strings/description/
 * 这道题，看看给的单词是不是一个套路的，有意思。
 * 如果使用 += 来拼接字符串，会出现性能问题
 * 网上看到的一种思路，感觉也是先进的不行。
 */
public class Novem07 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String cNum = checkFormat(s);
        String tNum = checkFormat(t);
        return Objects.equals(cNum, tNum);
    }

    private String checkFormat(String str) {
        StringBuilder num = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int index = 1;
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                num.append(map.get(c));
            } else {
                num.append(index);
                map.put(c, index);
                index++;
            }
        }
        return num.toString();
    }

    public boolean isIsomorphic1(String s, String t) {
        // 这种 思想不错
        // 就是说，强制绑定任意两点
        if (s.length() != t.length()) {
            return false;
        }
        int[] srr = new int[256];
        int[] trr = new int[256];
        Arrays.fill(srr, -1);
        Arrays.fill(trr, -1);
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (srr[sc] != trr[tc]) {
                return false;
            }
            // 强制约束 绑定在一起来
            srr[sc] = trr[tc] = i;
        }
        return true;
    }

    @Test
    public void test1() {
        System.out.println(isIsomorphic1("abca", "abcb"));
    }
}
