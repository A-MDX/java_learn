package com.m2017.december;

/**
 * 今天 看了继承，感觉某个地方很有意思。
 * Create by A-mdx at 2017/12/7 23:33
 */
public class December07 {
    
}
class Fruit{
    static int genVal(int val){
        System.out.println("gen:"+val);
        return val*2;
    }
    Fruit(){
        System.out.println("ok");
    }
}
class Apple extends Fruit{
    int a;
    Apple(){
        System.out.println("apple...");
        // 看这里，继承过去的不止是 方法，还可以又静态方法
        a = genVal(1);
    }
}
