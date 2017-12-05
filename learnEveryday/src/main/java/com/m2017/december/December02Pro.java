package com.m2017.december;

import org.junit.Test;

/**
 * java 中，平时的开发中用到的方法不是很多，但是如果掌握这类方法，
 * 我也不知道有何用，但，更好地理解整个java生态，会有一定帮助吧。
 * 两年了，该好好地稳固一下基础了。
 * 
 * 今天学习的是，从没有用过的 finally方法。
 * Create by A-mdx at 2017/12/2 16:27
 */
public class December02Pro {

    public static void main(String... args) {
        Book novel = new Book(true);
        novel.checkIn();
        new Book(true);
        
        System.gc();
    }
    
    @Test
    public void test1(){
        String str1 = "asd";
        for (int i = 0; i < 100000; i++) {
            str1 = str1+str1;
        }
        System.out.println("length:"+str1.length());
    }
    
    static class Book{
        boolean checkOut;
        int a;
        Book(){
            System.out.println("no arg init book...");
        }
        Book(boolean checkOut){
            System.out.println("a:"+a);
            this.checkOut = checkOut;
            System.out.println("has args init book...");
        }
        
        void checkIn(){
            this.checkOut = false;
        }

        @Override
        protected void finalize() throws Throwable {
            if (checkOut){
                System.out.println("Error.... forget check out");
            }
        }
    }
}
