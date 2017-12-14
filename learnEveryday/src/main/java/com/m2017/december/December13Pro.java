package com.m2017.december;

/**
 * 学习一下内部类
 * Create by A-mdx at 2017/12/13 22:54
 */
public class December13Pro {
    public static void main(String... args) {
        Outer outer = new Outer();
        System.out.println("out name:" + outer.getClass().getName());
        System.out.println(outer.say());
        Outer.Inner inner = outer.getInner();
        // 1. inner name:com.m2017.december.Outer$Inner
        System.out.println("inner name:" + inner.getClass().getName());
        System.out.println(inner.say());

        // 2.第一次见这种写法：直接创建 对象，因为内部类关联太深
        Outer.Inner inner1 = outer.new Inner();

        // 3.当将内部类向上转型为其基类，尤其是转型为一个接口时，内部类的作用来了。
        //   似乎在很多 list，stack 中有很多这样的。
    }
}

class Outer {
    class Inner {
        String say() {
            // 这个看着很奇葩
            String str = Outer.this.say();
            str = Outer.this.say();// ctrl+alt+space 可以直接强转 
            System.out.println(str);
            return "Hi, I'm inner...";
        }
    }

    String say() {
        return "Hi, I'm outer";
    }

    Inner getInner() {
        return new Inner();
    }
}
