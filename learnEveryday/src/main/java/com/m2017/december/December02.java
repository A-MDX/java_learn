package com.m2017.december;

import org.junit.Test;

import java.util.Random;

/**
 * 也算是巩固一下基础
 * Create by A-mdx at 2017/12/2 0:08
 * 想想我这苦逼的生活
 */
public class December02 {

    @Test
    public void test1() {
        // 主要是想看一些好玩的事情。
        int a = Integer.MIN_VALUE;
        int b = 0;
        while (true) {
            System.out.println("a:" + Integer.toBinaryString(a) + " ----------------------------------- " + a);
            b = a >> 1;
            if (a != b) {
                a = b;
            } else {
                break;
            }
        }
    }

    @Test
    public void test2() throws Exception {
//        这个三目运算法还能这么玩，也是醉了。
        boolean a = true;
        boolean b = false;

        int c = a ? b ? 2 : 7 : a ? 19 : 20;
        System.out.println("c: " + c);
    }

    @Test
    public void test3() throws Exception {
        // 测试 for 循环
        int a = 5;
        for (a++; a > 0; ) {
            System.out.println("a: " + a);
            a--;
        }
        for (; ; )
            System.out.println("xxx");
    }

    @Test
    public void test4() throws Exception {
        // 这种循环中的跳转，用处不大，而且一般两个循环就足够了，三个嵌套循环实在少见。
        sb1:
        for (int i = 0; i < 10; i++) {
            System.out.println("i:" + i);
            sb2:
            for (int j = i; j < 10; j++) {
                System.out.println("j:" + j);
                for (int k = j; k < 10; k++) {
                    System.out.println("k:" + k);
                    if (k == 2) {
                        System.out.println("continue sb2;");
                        continue sb2;
                    }
                    if (k == 4) {
                        System.out.println("break sb2;");
                        break sb2;
                    }
                    if (k == 6) {
                        System.out.println("break sb1;");
                        break sb1;
                    }

                }
            }
        }
    }

    @Test
    public void test5() throws Exception {
        // 好久没有用 switch 了
        Random random = new Random();
        int a = random.nextInt(10);
        System.out.println("a : " + a);
        switch (a) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("fuck....");
            default:
                System.out.println("xxx");
        }
    }

    @Test
    public void test6() throws Exception {
        
    }
    class Boo{
        int val;
        Boo(){
            System.out.println("no args init...");
        }
        Boo(int x){
            super();
            // 因为调用父类 或者 其他构造函数只能放第一位，所以，就不能调第二个了
//            this();
            val = x;
        }
        
        
    }
}
