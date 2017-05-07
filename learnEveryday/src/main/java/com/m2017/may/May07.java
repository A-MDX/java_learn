package com.m2017.may;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 * Created by A-mdx on 2017/5/7.
 * https://leetcode.com/problems/word-break/#/description
 * 继续昨天的，因为时间总是太长，今天得学学动态规划算法了。
 * 哎，自己想也很难想到这样了。
 */
public class May07 {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] hehe = new boolean[s.length()+1];
        hehe[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String str = s.substring(j, i);
                System.out.println("str->"+str);
                
                // 这里的逻辑，hehe[j]是说，只有前面到j这个位置，到j被分割过（存在包含前方切割字符串），
                // 其才能继续走下去，查看是否包含。
                if (hehe[j] && wordDict.contains(str)){
                    hehe[i] = true;
                    break;
                }
            }
            
        }
        System.out.println(Arrays.toString(hehe));
        return hehe[s.length()];
    }

    /**
     * 可以使用 alt + insert 快速构建测试方法
     */
    @Test
    public void test1() {

        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    /**
     * 可以使用 alt + insert 快速构建测试方法
     */
    @Test
    public void test2() {

        System.out.println(wordBreak("bccdbacdbdacddabbaaaadababadad", Arrays.asList("cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb")));
    }
}
