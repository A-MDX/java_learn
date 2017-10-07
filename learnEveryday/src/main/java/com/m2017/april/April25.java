package com.m2017.april;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * 这个递归用的好难，感觉还是需要学习好久，这次是摘抄别人的
 * Created by A-mdx on 2017/4/25.
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class April25 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
    
    @Test
    public void test1(){
        List<String> list = generateParenthesis(3);
        list.forEach(System.out::println);
    }
    
}
