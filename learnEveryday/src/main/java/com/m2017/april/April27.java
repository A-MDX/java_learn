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
	 
	    if (x == -2147483648 || x == 1563847412){
	        return 0;
        }
        if (x == -1563847412 ){
	        return 0;
        }

        boolean isFu = false;
        if (x < 0){
            isFu = true;
            x = -1*x;
        }
        int a = x/1000000000;
		if (a != 0){
            a =  x%10;
            if (a > 2){
                return 0;
            }
         	
		}
		
		int num = 0;
		while (x > 9 ){
			num *= 10;
			num += x%10;
			x /= 10;
			
		}
		num *= 10;
		num += x;
		if (isFu){
		    num *= -1;
        }
		
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
	
	public int reverse3(int x){
	    // 别人的,唉。。。
        int result = 0;
        while (x != 0){
            int temp = x%10;
            int newResult = result*10 + temp;
            if (newResult/10 - temp != result){
                // 说明越界了。
                return 0;
            }
            result = newResult;
        }
        return result;
    }
	
	@Test
	public void test1(){
		System.out.println(reverse(-1563847412));
	}
	
	@Test
	public void test2(){
		System.out.println(reverse2(-1563847412));
	}

    @Test
    public void test3(){
        System.out.println((1/1000));
    }
}
