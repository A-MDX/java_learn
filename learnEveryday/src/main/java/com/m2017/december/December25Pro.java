package com.m2017.december;

import org.junit.Test;

/**
 * 平时开发中，基本很少用到异常，今天晚上学习一下异常，准备再好好学习一番
 * 关于异常，想要测试一下不同情况下，异常会有泽洋的表现
 * Create by A-mdx at 2017/12/25 23:28
 */
public class December25Pro {
    class BaseException extends Exception {
        BaseException() {
            System.out.println("Base...");
        }
    }

    interface Etest {
        void f1() throws BaseException;

        void f2();
    }

    class EtestImpl implements Etest {

        @Override
        public void f1() throws BaseException {

        }

        @Override
        public void f2() {
            // 一般是不准 破坏接口封装性的
            // 所以，不准添加 throws BaseException 
        }
    }

    void f() {
        throw new RuntimeException("hehe");
    }

    // finally, 如果在 构造函数 中 使用了 finally，这个finally 不知道还能否 被 执行
    class Apple {
        Apple() {
            try {
                f();
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                System.out.println("finally fuck...");
            }
        }
    }

    @Test
    public void test1() {
        Apple apple = new Apple();
        // 看来也是会 执行到的
    }
}
