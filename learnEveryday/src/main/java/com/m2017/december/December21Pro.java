package com.m2017.december;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.logging.Logger;

/**
 * 看书中，正在学习异常类，想尝试一个好玩的方法。
 * Create by A-mdx at 2017/12/21 23:58
 */
public class December21Pro {

    // 这个叫做，使用 while 寻混建立了一个类似 恢复模型 的异常处理行为，其将不断重复，直到异常不再抛出
    @Test
    public void test1() {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(50);
            try {
                if (num > 10) {
                    throw new RuntimeException("fuck:" + num);
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
                continue;
            }
            System.out.println("num: " + num);
            break;
        }
    }

    static Logger logger = Logger.getLogger("December21Pro");

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    // 只是想测试一下 java 自带的 log包，没想到这么难用
    @Test
    public void test2() {
        logger.info("hehehe");
        logger.severe("what a nice day....");
        System.out.println("------------------------------------");
        try {
            throw new UnsupportedOperationException("fuck ....");
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            System.out.println("---------------------");
//            logException(e);
        }

    }


    class FkException extends RuntimeException {
        int val;

        FkException(String msg, int num) {
            super(msg);
            val = num;
        }

        FkException(int num) {
            val = num;
        }

        @Override
        public String getMessage() {
            return "Detail is that: val = " + val + " ---> " + super.getMessage();
        }
    }

    @Test
    public void test3() {
        try {
            throw new FkException("dangdangdang", 2);
        } catch (FkException e) {
            e.printStackTrace();
        }
    }
}
