package com.m2017.december;

import org.junit.Test;

import java.util.HashMap;

/**
 * p330
 * 学到有关Class 的内容，在思考，是否可以😩 不用这么麻烦的方法。
 * 书上写的实在捉急
 * Create by A-mdx at 2017/12/31 1:00
 */
public class December30Pro {

    @Test
    public void test1() {
        TypeCounter<Book> counter = new TypeCounter<>();
//        counter.count("123");
        counter.count(new YellowBook());
        counter.count(new NickYellowBook());
        System.out.println(counter);
    }

}

class TypeCounter<T> extends HashMap<Class<? extends T>, Integer> {
    public void count(T obj) {
        Class c = obj.getClass();
        countClass(c);
    }

    private void countClass(Class c) {
        computeIfPresent(c, (k, v) -> ++v);
        putIfAbsent(c, 1);
        Class superClass = c.getSuperclass();
        if (superClass != null) {
            countClass(superClass);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}