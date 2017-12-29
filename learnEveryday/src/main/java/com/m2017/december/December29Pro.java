package com.m2017.december;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * 今天看到这个方法实在很好玩，可能有助于我理解 io
 * p309
 * <p>
 * p317 有关 Class 的内容
 * Create by A-mdx at 2017/12/30 0:34
 */
public class December29Pro {

    // 方法体太过简单，懒得写了，主要好奇 这个 StringReader...
    BufferedReader reader = new BufferedReader(new StringReader("Sir Robin of Camelot\n" +
            "22 1.16803"));

    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName("com.m2017.december.NickYellowBook");
        System.out.println("c : " + c);
        System.out.println(c.getName());
        System.out.println(c.isInterface());
        System.out.println(c.getSimpleName());
        System.out.println(c.getCanonicalName());
        System.out.println(c.getPackageName());
        System.out.println("*****************************************************");
        System.out.println(c.getSuperclass());
        Book book = (Book) c.newInstance();
        System.out.println(book);
        System.out.println(book.read());
    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        // 匿名类 会咋样？
        Book book = () -> "read,,,read,,,done...";
        Class c = book.getClass();
        System.out.println("c : " + c);
        System.out.println(c.getName());
        System.out.println(c.isInterface());
        System.out.println(c.getSimpleName());
        System.out.println(c.getCanonicalName());
        System.out.println(c.getPackageName());

        System.out.println(book);

        System.out.println("---------------------");

        // java.lang.IllegalAccessException：class com.m2017.december.December29Pro
        // cannot access a member of class com.m2017.december.December29Pro$$Lambda$39/1859039536 with modifiers "private"
        // 匿名类看来不准 实现了。
        book = (Book) c.newInstance();

        System.out.println(book);

    }
}

interface Book {
    String read();
}

class YellowBook implements Book {

    @Override
    public String read() {
        return "so nice book...";
    }
}

class NickYellowBook extends YellowBook {

    static {
        System.out.println("yes, in init.");
    }

    @Override
    public String read() {
        System.out.println("It's good to read...");
        return super.read();
    }
}