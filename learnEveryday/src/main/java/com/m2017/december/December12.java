package com.m2017.december;

import java.util.Arrays;

/**
 * 看书的时候，突然想试试，这么玩会发生啥
 * 1. 学习一下关于 多态，继承，实现，解耦等基本概念
 * 2. 练习一下 泛型
 * Create by A-mdx at 2017/12/12 23:15
 */
public class December12 {
    static void apply(Process process, Object obj) {
        System.out.println("name: " + process.name());
        System.out.println(process.process(obj));
    }

    public static void main(String... args) {
        String str = "I am your big brother. and I'm watching you.";
        apply(new Upcase(), str);
        apply(new DownCase(), str);
        apply(s -> Arrays.toString(s.toString().split("\\.")), str);

        System.out.println("-------------------------------------");

        apply2(s -> s.split("\\.")[0], str);
    }

    // 约束了泛型
    static void apply2(Process<String> process, String str) {
        System.out.println("name: " + process.name());
        System.out.println(process.process(str));
    } 
    /*
    原来匿名函数会这样。
name: Upcase + com.m2017.december.Upcase
I AM YOUR BIG BROTHER. AND I'M WATCHING YOU.
name: DownCase + com.m2017.december.DownCase
i am your big brother. and i'm watching you.
name: December12$$Lambda$1/1289479439 + com.m2017.december.December12$$Lambda$1/1289479439
[I am your big brother,  and I'm watching you]
-------------------------------------
name: December12$$Lambda$2/901506536 + com.m2017.december.December12$$Lambda$2/901506536
I am your big brother
     */
}

@FunctionalInterface
interface Process<T> {
    T process(T input);

    default String name() {
        return getClass().getSimpleName() + " + " + getClass().getName();
    }
}

class Upcase implements Process<String> {

    @Override
    public String process(String input) {
        return input.toUpperCase();
    }
}

class DownCase implements Process<String> {

    @Override
    public String process(String input) {
        return input.toLowerCase();
    }
}