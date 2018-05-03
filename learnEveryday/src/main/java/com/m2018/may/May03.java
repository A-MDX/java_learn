package com.m2018.may;

import java.util.*;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * Create by A-mdx at 2018-05-03 22:10
 * 这道题没啥子难度
 */
public class May03 {

}

class WordDictionary {

    private Map<Integer, Set<String>> map;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        int length = word.length();
        Set<String> set = map.get(length);
        if (set == null) {
            set = new HashSet<>();
            set.add(word);
            map.put(length, set);
        } else {
            set.add(word);
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        int length = word.length();
        Set<String> set = map.get(length);
        if (set == null) {
            return false;
        }
        List<String> temp = new ArrayList<>(set);
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            temp = checkForSearch(i, arr, temp);
            if (temp.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private List<String> checkForSearch(int i, char[] arr, List<String> temp) {
        char now = arr[i];
        if (now == '.') {
            return temp;
        }
        List<String> list = new ArrayList<>();
        for (String s : temp) {
            if (s.charAt(i) == now) {
                list.add(s);
            }
        }
        return list;
    }
}