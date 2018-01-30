package com.m2018.january;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 临近年关，越发不想写了
 * p549
 * 主要是想体验一下不适用 scanner 来读取怎么样
 * Create by A-mdx at 2018-01-30 23:32
 */
public class January30 {

    public static void main(String... args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println("-----------> " + s);
        }
    }

    @Test
    public void test1() {

        PrintWriter writer = new PrintWriter(System.out, true);
        writer.println("hehhehe");
        writer.println("123");
        writer.println("123");
        writer.println("qwe");
        writer.println("12312");
    }

}
