package com.m2017.october;

import org.junit.Test;

/**
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 * Created by a-mdx on 2017/10/20.
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 */
public class Octo20 {

    public int lengthOfLastWord(String s) {
        int len=s.length(), lastLength=0;

        while(len > 0 && s.charAt(len-1)==' '){
            len--;
        }

        while(len > 0 && s.charAt(len-1)!=' '){
            lastLength++;
            len--;
        }

        return lastLength;
    }

    public int lengthOfLastWord1(String s) {
        int allLength = s.length();
        int lastIndex = s.lastIndexOf(' ');
        return allLength - lastIndex-1;
    }

    @Test
    public void test1(){
        System.out.println(lengthOfLastWord("Hello World"));
    }

}
