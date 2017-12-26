package com.m2017.december;

import org.junit.Test;

/**
 * 看书，主要有两块知识
 * 1. String 类的 基本运行原理
 * 2. 了解一下有关 jvm 字节码的知识
 * Create by A-mdx at 2017/12/27 0:18
 * thinking in java p285
 */
public class December26Pro {
    public String implicit(String... args) {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            result += args[i];
        }
        return result;
    }

    public String explicit(String... args) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            result.append(args[i]);
        }
        return result.toString();
    }

    @Test
    public void test1() {
        System.out.println(implicit("zzz", "heheh", "xxx"));
        System.out.println(explicit("aaa", "bbb", "ccc"));
    }

    @Test
    public void test2() {
        StringBuilder str = new StringBuilder();
        str.append("123");
        str.append(789);

        System.out.println("str:" + str);

        StringBuilder bbq = new StringBuilder();
        bbq.append(789 + "zxc");
        
        // 通过 javap -c December26Pro ，发现下面这个 会造成 虚拟机 在append 里面直接创建这个 参数
        // 68: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
        // 天，简直神奇
        bbq.append("123" + "xcc" + str.toString());
        System.out.println("bbq:" + bbq);
    }
}
