package com.m2018.january;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create by A-mdx at 2018/1/1 18:41
 */
public class January01Pro1 {
    public static void main(String... args) {
        SomeMethods someMethods = (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(), new Class[]{SomeMethods.class}
        , new SmProxy(new SomeMethods(){}));
        someMethods.boring1();
        someMethods.boring2();
        someMethods.interesting("hehe");
        someMethods.boring3();
    }
}
class SmProxy implements InvocationHandler{

    private SomeMethods someMethods;
    SmProxy(SomeMethods someMethods){
        this.someMethods = someMethods;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting")){
            System.out.println("I got a interesting things...");
        }
        return method.invoke(someMethods, args);
    }
}

interface SomeMethods{
    default void boring1(){
        System.out.println("so boring1....");
    }
    default void boring2(){
        System.out.println("so boring2....");
    }
    default void interesting(String args){
        System.out.println("interesting things..."+args);
    }
    default void boring3(){
        System.out.println("so boring3....");
    }
}
