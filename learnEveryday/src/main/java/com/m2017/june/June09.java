package com.m2017.june;

import org.junit.Test;

import java.util.*;

/**
 * Group Anagrams
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.
 * Created by A-mdx on 2017/6/15.
 * https://leetcode.com/problems/group-anagrams/#/description
 * 
 */
public class June09 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> reList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String b = new String(arr);
            if (map.containsKey(b)){
                List<String> list = map.get(b);
                list.add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(b, list);
            }
        }
        map.forEach((k,v) -> {
            v.sort(String::compareTo);
            reList.add(v);
        });
        reList.sort((s1,s2) -> s2.size()-s1.size());
        return reList;
    }
    
    @Test
    public void test1(){
        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> reList = groupAnagrams(list);
        reList.forEach(System.out::println);
    }
}
