package com.m2018.january;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 今天是18年的第一天，前来学习一下有关反射的知识
 * p336
 * Create by A-mdx at 2018/1/1 17:56
 */
public class January01Pro {
    @Test
    public void test1() {
        System.out.println("111");
    }

    public void checkArgs(String... args) {
        for (String arg : args) {
            if (arg == null) {
                throw new RuntimeException("fuck...");
            }
        }
    }

    @Test
    public void test2() {
        int a = 100;
        int b = 237;
        System.out.println(Math.sqrt(a*a + b*b));
    }

    private int i;

    private String name;
    private double salary;


    public static String replaceSome(String source) {
        return source.replaceAll("\\w+\\.", "");
    }

    public January01Pro(){
        
    }
    
//    public January01Pro(int a) {
//        System.out.println("a : " + a);
//    }

    public static void main(String... args) throws ClassNotFoundException {
        Class c = Class.forName("com.m2018.january.January01Pro");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field);
        }
        System.out.println("................");
        Method[] methods = c.getMethods();
        Constructor[] constructors = c.getConstructors();
        for (Method method : methods) {
            System.out.println(replaceSome(method.toString()));
        }
        System.out.println("-----------------------------------------------");
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }
    }
}
