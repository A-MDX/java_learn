package com.m2017.november;

/**
 * 最近看了这本巨作，java编程思想，想着学学看吧
 * 决定会不定期的更新 各种代码思想方法等，不再局限于 算法。
 * Create by a-mdx at 2017/11/30 0:13
 */
public class Novem30 {
    public static void main(String... args) {
        String home = System.getenv("JAVA_HOME");
        System.out.println("home: "+ home);
        System.getProperties().list(System.out);
        System.out.println(
                System.getProperty("java.library.path")
        );
    }
}
