package com.m2017.april;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Created by A-mdx on 2017/4/24.
 * 今天这个等于复习了一遍String.contains(str)方法，subString(0,2),startWith()
 */
public class April24 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0){
			return "";
		}
		Arrays.sort(strs, Comparator.comparingInt(String::length));
//		System.out.println(Arrays.deepToString(strs));
		String str = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (!strs[i].startsWith(str)){
				
				if (str.length() == 1){
					return "";
				}
				
				str = str.substring(0, str.length()-1);

				i = i-1;
			}
		}
		
		return str;
	}
	
	@Test
	public void test1(){
		String[] arr = {"aa","ab"};
		String str = longestCommonPrefix(arr);
		System.out.println(str);
	}
	
	@Test
	public void test2(){
		String str = "1234567890abcdefg";
		System.out.println(str.substring(0,10));
		System.out.println(str);
	}
}
