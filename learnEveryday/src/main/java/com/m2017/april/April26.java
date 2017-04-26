    package com.m2017.april;

    import org.junit.Test;

    /**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999
 * Created by A-mdx on 2017/4/26.
 * https://zh.wikipedia.org/wiki/%E7%BD%97%E9%A9%AC%E6%95%B0%E5%AD%97
 * 
 */
public class April26 {
    
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int last = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = trans(arr[i]);
            if (last == 0){
                last = temp;
                continue;
            }
            if (temp > last){
                sum += temp-last;
                last = 0;
                
            }else{
                sum += last;
                last = temp;
            }
        }
        sum += last;
        return sum;
    }
    
    public int trans(char c){
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    
    @Test
    public void test1(){
        String str = "MCMXCVI";
        System.out.println(romanToInt(str));
    }
        
}
