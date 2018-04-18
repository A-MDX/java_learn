package com.m2018.april;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * Create by A-mdx at 2018-04-18 20:50
 * https://leetcode-cn.com/problems/ransom-note/description/
 * 有时候感觉思维陷入了一种误区，完全可以反着来，🙂
 */
public class April18 {

    // 参考他人想法
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()){
            arr[c -'a']++;
        }
        for (char c : ransomNote.toCharArray()){
            if (--arr[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
    
    // 这个利用数组，似乎快多了，但还是很一般
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] arr = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int temp = c - 'a';
            arr[temp]++;
        }
        for (char c : magazine.toCharArray()) {
            int temp = c - 'a';
            arr[temp]--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }


    // 姿势不够优雅，再考虑一下有没有更好的
    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.computeIfPresent(c, (k, v) -> v + 1);
            map.putIfAbsent(c, 1);
        }
        for (char m : magazine.toCharArray()) {
//            if (map.containsKey(m)){
//                int val = map.get(m);
//                val--;
//                if (val < 0){
//                    
//                }
//            }
            map.computeIfPresent(m, (k, v) -> v - 1);
        }
//        AtomicBoolean result = new AtomicBoolean(true);
        boolean[] result = {true};
        map.forEach((k, v) -> {
            if (v > 0) {
//                result.set(false);
                result[0] = false;
            }
        });
        return result[0];
    }

    @Test
    public void test1() {
        System.out.println(canConstruct("bg",
                "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}
