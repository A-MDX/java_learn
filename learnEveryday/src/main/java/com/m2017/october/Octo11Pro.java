package com.m2017.october;

import org.junit.Test;

import java.util.*;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Created by a-mdx on 2017/10/11.
 * https://leetcode.com/problems/valid-parentheses/description/
 * 这个一看就知道需要用到 栈 这个数据结构，可以复习一下了
 */
public class Octo11Pro {
    public boolean isValid1(String s) {
//        List<Character> chars = Arrays.asList(')',']','}');
        Map<Character, Character> chars = new HashMap<>();
        chars.put(')','(');
        chars.put(']','[');
        chars.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (chars.containsKey(c)){
                Character x = stack.peek();
//                System.out.println(x.equals(chars.get(c)));
                if (stack.isEmpty() || (!stack.pop().equals(chars.get(c)))){
                    return false;
                }

            }else {
                stack.push(c);
            }
        }

        return true;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            switch (c){
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('(')){
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || !stack.pop().equals('{')){
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('[')){
                        return false;
                    }
                    break;
                default:
                    stack.push(c);

            }
        }
        
        if (stack.size() != 0){
            return false;
        }

        return true;
    }

    @Test
    public void test1(){
        System.out.println(isValid("(())"));
    }

}
