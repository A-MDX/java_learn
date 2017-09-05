package com.m2017.september;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by a-mdx on 2017/9/4.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * 好久都没写，罪过; 这个属于找不同咯？
 */
public class Sept01 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1, bmax = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if (map.containsKey(temp)) {
                if (bmax < max) {
                    bmax = max;
                }
                int end = map.get(temp);
                for (int j = start; j < end; j++) {
                    map.remove(s.charAt(j));
                }
                map.put(temp, i);

                start = end + 1;

                max = i - end;

            } else {
                map.put(temp, i);
                max++;
            }
        }

        if (bmax < max) {
            bmax = max;
        }

        return bmax;
    }

    public int lengthOfLongestSubstring1(String s) {
        // 超时了，废弃

        // 应该只需要一个循环，，，
        int max = 1, bmax = 1;
        if (s.length() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int last = s.charAt(0);
        map.put(last, 0);
        for (int i = 1; i < s.length(); i++) {
            int now = s.charAt(i);
            if (map.containsKey(now)) {
                if (bmax < max) {
                    bmax = max;
                }

                i = map.get(now);
                map.clear();
                // 重新走一遍
                max = 1;
            } else {
                map.put(now, i);
                max++;
            }

        }

        if (bmax < max) {
            bmax = max;
        }

        return bmax;
    }

    @Test
    public void test1() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
