package com.m2017.november;

import org.junit.Test;

/**
 * 今天继续学习一些骚操作。
 * Create by A-mdx at 2017/11/30 23:11
 */
public class Novem30Pro {
    
    @Test
    public void test1(){
        int i1 = 0x2f;
        System.out.println("i1:"+i1);
        System.out.println("i1:"+Integer.toBinaryString(i1));
        
        int i2 = 0456;
        System.out.println("i2:"+i2);
    }

    @Test
    public void test2() throws Exception {
        double i = 1.5e5;
        System.out.println("i:"+i);
    }

    @Test
    public void test3() throws Exception {
        boolean a = false;
        boolean b = true;
        System.out.println("a|b:"+(a|b));
        System.out.println("a&b:"+(a&b));
        // 也就是说，^ 这个符号所代表的含义是，如果两者不同，才会为true，这个叫异或
        System.out.println("a^b:"+(a^b));


    }

    @Test
    public void test4() throws Exception {
        int a = 0b1010110;
        int b = 0b0101001;

        String result = Integer.toBinaryString((a|b));
        System.out.println("a|b:"+result);
        System.out.println("a&b:"+Integer.toBinaryString((a&b)));

        System.out.println("------------------------------------------------------------------------");

        System.out.println("boo:"+(boo2() & boo1()));
        
    }
    
    public boolean boo1(){
        System.out.println("boo1..................");
        return true;
    }
    public boolean boo2(){
        System.out.println("boo2..................");
        return false;
    }

    @Test
    public void test5() throws Exception {
        int i = 10;
        System.out.println("i:"+Integer.toBinaryString(i));

        System.out.println("~i:"+Integer.toBinaryString(~i));
        System.out.println("i:"+Integer.toBinaryString(~i));
        
        i = i >> 1;
        System.out.println("i:"+Integer.toBinaryString(i));
    }
}
