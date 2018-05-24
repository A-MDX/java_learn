package com.m2018.may;

import org.junit.Test;

import java.util.Arrays;

/**
 * Create by A-mdx at 2018-05-06 15:22
 */
public class May06 {
    
    @Test
    public void test1(){
        double a = 1e5;
        System.out.println(a);
        
        double b = 3.14 + 1e20 - 1e20;
        System.out.println(b);
        
        int c = 2;
        for (int i = 0; i < 7; i++) {
            c *= 2;
        }
        System.out.println(c);
    }
    
    public static void main(String... args) {
        int[] arr = {4, 8, 9, 6, 2, 17, 7, 1};
        minPrint(arr);

    }

    public static void minPrint(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (array[i] > array[j]) {
                    int a = array[i];
                    array[i] = array[j];
                    array[j] = a;

                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
