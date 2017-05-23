package com.m2017.may;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find All Anagrams in a String
 * 找到所有的同子异构体？
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * Input:
 * s: "abab" p: "ab"
 * Output:
 * [0, 1, 2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * Created by A-mdx on 2017/5/23.
 */
public class May23 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) {
            return list;
        }
        int[] prr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            prr[p.charAt(i) - 'a']++;
        }

        char[] srr = s.toCharArray();
        Integer g;
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            g = i;
            if (isAnagrams(Arrays.copyOf(prr, prr.length), g, srr, p.length())) {
                list.add(i);
            } else {
                i = g;
            }
        }


        return list;
    }

    private boolean isAnagrams(int[] prr, Integer i, char[] srr, int length) {
        for (int j = i; j < i + length; j++) {
            int num = srr[j] - 'a';
            prr[num]--;
            if (prr[num] < 0) {
                i = j;
                return false;
            }
        }

        return true;
    }

    @Test
    public void test1() {
        // s: "cbaebabacd" p: "abc"
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
    }
}
