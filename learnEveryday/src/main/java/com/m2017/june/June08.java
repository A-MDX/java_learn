package com.m2017.june;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Decode String
 * Given an encoded string, return it's decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * Created by A-mdx on 2017/6/8.
 * https://leetcode.com/problems/decode-string/#/description
 * 没做出来，看来栈这个数据结构用的不好。
 */
public class June08 {
    
    String numRex = "[0-9]{1,10}";
    String strRex = "[a-z]{1,1000}";
    Pattern numP = Pattern.compile(numRex);
    Pattern strP = Pattern.compile(strRex, Pattern.CASE_INSENSITIVE);

    Solution solution = new Solution();
    
    public static void main(String[] args) {
        June08 june08 = new June08();
        String s = "3[a]2[bc]";
        String str = june08.solution.decodeString(s);
        System.out.println(str);
        str = june08.decodeStr(s);
        System.out.println(str);
    }
    
    public String decodeStr(String s){
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int index = 0;
        while (index < s.length()){
            char c = s.charAt(index);
            if (Character.isDigit(c)){
                int count = 0;
                while (Character.isDigit(c)){
                    count = 10*count+ (c - '0');
                    index++;
                    c = s.charAt(index);
                }
                countStack.add(count);
            } else if (c == '['){
                resStack.add(res);
                res = "";
                index++;
            } else if (c == ']'){
                // 清算
                StringBuilder temp = new StringBuilder(resStack.pop());
                int size = countStack.pop();
                for (int i = 0; i < size; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }else {
                res += c;
                index++;
            }
        }
        
        return res;
        
    }
    
    // Simple Java Solution using Stack
    public class Solution {
        public String decodeString(String s) {
            String res = "";
            Stack<Integer> countStack = new Stack<>();
            Stack<String> resStack = new Stack<>();
            int idx = 0;
            while (idx < s.length()) {
                if (Character.isDigit(s.charAt(idx))) {
                    int count = 0;
                    while (Character.isDigit(s.charAt(idx))) {
                        count = 10 * count + (s.charAt(idx) - '0');
                        idx++;
                    }
                    countStack.push(count);
                }
                else if (s.charAt(idx) == '[') {
                    resStack.push(res);
                    res = "";
                    idx++;
                }
                else if (s.charAt(idx) == ']') {
                    StringBuilder temp = new StringBuilder (resStack.pop());
                    int repeatTimes = countStack.pop();
                    for (int i = 0; i < repeatTimes; i++) {
                        temp.append(res);
                    }
                    res = temp.toString();
                    idx++;
                }
                else {
                    res += s.charAt(idx++);
                }
            }
            return res;
        }
    }
    // 错的
    public String decodeString1(String s) {
        StringBuilder sb = new StringBuilder();
        List<Integer> ints = new ArrayList<>();
        List<String> strs = new ArrayList<>();
        while (s.contains("[")){
            String[] splits = s.split("\\[");
            ints.add(Integer.valueOf(splits[0]));
            int start = s.indexOf("[");
            int end = s.indexOf("]");
            String str = s.substring(start+1, end);
            
//            while (str.contains("[")){
//                
//            }
            if (str.contains("[")){
                // 有数据 str 要重新变更
                end = s.indexOf("]", end+1);
                str = s.substring(start+1, end);
                
                String temp = str.split(numRex)[0];
                str = str.substring(temp.length());
                str = temp + decodeString1(str);
                
            }
            strs.add(str);

            s = s.substring(end+1);
            
        }
        for (int i = 0; i < ints.size(); i++) {
            int times = ints.get(i);
            String str = strs.get(i);
            for (int j = 0; j < times; j++) {
                sb.append(str);
            }
        }
        
        return sb.toString();
    }

    @Test
    public void test2() throws Exception {
        String s = "3[a2[c]b]";
        System.out.println(decodeString1(s));
    }

    @Test
    public void test3() throws Exception {
        String s = "2asb";
        System.out.println(s.split(numRex)[0]);
    }

    @Test
    public void test1(){
        String s = "3[a]2[bc]";
        int start = s.indexOf("[");
        System.out.println("start:"+start);
        int end = s.indexOf("]");
        System.out.println("end:"+end);
        System.out.println(s.substring(end+1));
        
        start = s.indexOf("[", start+1);
        System.out.println("start:"+start);
        end = s.indexOf("]", end+1);
        System.out.println("end:"+end);

        System.out.println(s.substring(start+1, end));
        
    }
    
}
