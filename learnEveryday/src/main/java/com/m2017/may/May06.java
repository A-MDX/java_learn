package com.m2017.may;

import org.junit.Test;

import java.util.ArrayList;
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
 * Created by A-mdx on 2017/5/6.
 * https://leetcode.com/problems/word-break/#/description
 * 这等于还复习了一遍正则表达式，再加上 Arrays类的使用，还复习一遍迭代器。。
 * 哎，看别人似乎需要学会DP 算法才行，DP，动态规划算法。。。。
 */
public class May06 {
    public boolean wordBreak(String s, List<String> wordDict) {
        String old = s.replaceAll("[a-zA-Z]", "-");
        System.out.println(old);

        return findStr(s, wordDict, old);
    }

    private boolean findStr(String s, List<String> wordDict, String old) {
        if (old.equals(s)) {
            return true;
        }
        wordDict = new ArrayList<>(wordDict);

        String[] strings = new String[wordDict.size()];
        wordDict.toArray(strings);
        boolean ok;
        /*
        // 这此竟然运行了 45s ，醉了。
        Iterator<String> iterator = wordDict.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (s.contains(str)){
                String replace = str.replaceAll("[a-zA-Z]", "-");
                ok = findStr(s.replaceFirst(str, replace), wordDict, old);
                if (ok){
                    return true;
                }
            }else {
                iterator.remove();
            }
        }
        return false;
        */
        // 这个方法能用，就是超时了。。 我去,跑了2min24s 。。。
        for (int i = 0; i < wordDict.size(); i++) {
            String str = wordDict.get(i);
            if (s.contains(str)) {

//                String[] arr = Arrays.copyOfRange(strings, i, strings.length);

                String replace = str.replaceAll("[a-zA2-Z]", "-");

                ok = findStr(s.replaceFirst(str, replace), wordDict, old);
                if (ok) {
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * 可以使用 alt + insert 快速构建测试方法
     */
    @Test
    public void test1() {

        System.out.println(wordBreak("bccdbacdbdacddabbaaaadababadad", Arrays.asList("cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb")));
    }


}
