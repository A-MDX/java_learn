package com.m2017.april;

import org.junit.Test;

/**
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * Created by A-mdx on 2017/4/27.
 */
public class April27 {
	public int reverse(int x) {
		int num = 0;
		while (Math.abs(x) > 9 ){
			num *= 10;
			num += x%10;
			x /= 10;
			
		}
		num *= 10;
		num += x;
		
		
		return num;
	}
	
	public int reverse2(int x){
		boolean isFu = false;
		if (x < 0){
			isFu = true;
		}
		String str = x+"";
		if (isFu){
			str = str.replace("-","");
		}
		int num =0;
		char[] arr = str.toCharArray();
		int temp = 1;
		for (int i = 0; i < arr.length; i++) {
			
			num += Integer.parseInt(arr[i]+"") * temp;
			temp *= 10;
		}
		if (isFu){
			num *= -1;
		}
		return num;
	}
	
	@Test
	public void test1(){
		System.out.println(reverse(7569));
	}
	
	@Test
	public void test2(){
		System.out.println(reverse2(-456));
	}
}
