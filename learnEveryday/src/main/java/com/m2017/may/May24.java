package com.m2017.may;

import org.junit.Test;

import java.util.Arrays;

/**
 * Permutation in String
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False
 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 * Created by A-mdx on 2017/5/24.
 * https://leetcode.com/problems/permutation-in-string/#/description
 * 跟昨天的类似呀。
 */
public class May24 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int[] arr = new int[26];
        for (char c : s1.toCharArray()){
            arr[c-'a']++;
        }
        int s = s1.length();
        int l = s2.length();
        int i=0;
        char[] crr = s2.toCharArray();

        int[] carr;
        for (int k = 0; k < l-s+1; k++) {
            i = k;
            carr = Arrays.copyOf(arr, arr.length);
            while (i - k < s){
                if (--carr[crr[i] - 'a'] < 0){
                    if (arr[crr[i] - 'a'] -1 < 0){
                        k = i;
                        break;
                    }
                    i = k;
                    break;
                }
                i++;
            }
            if (i-k == s){
                return true;
            }
            
        }
        return false;
    }
    
    @Test
    public void test1(){
        System.out.println(checkInclusion("kuzntqeuvaszrspkgjvxrupwxwrexztptsowceibeewxbslvosbobmyymikdscshybtmanuxeqtanrjekbwirmhgvfmzipfiqxcilarfyasoayepgf", "zthosfejqodcstlqczkndmgwtcakxzxaklkrehkfwnokclametzpnblcwaspdblfoopsiqrpzlbmlysddlqxcjzezcpknwzljvhmqxqinmptcppipi"));
    }
}
