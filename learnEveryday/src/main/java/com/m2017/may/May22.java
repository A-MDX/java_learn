package com.m2017.may;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Created by A-mdx on 2017/5/22.
 * https://leetcode.com/problems/valid-anagram/#/description
 * 找出同字异构体？挺简单的
 */
public class May22 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // init map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println(map);

        // query and depend...
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if (map.containsKey(c)) {
                int length = map.get(c);
                length--;
                if (length <= 0) {
                    map.remove(c);
                } else {
                    map.put(c, length);
                }
            } else {
                return false;
            }
        }
        System.out.println(map);

        return true;
    }

    @Test
    public void test1() {
        System.out.println(isAnagram("aacc", "ccac"));
    }
}
