package com.m2017.december;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Formatter;

/**
 * 今天学一下，String 以及 一个从没遇到过的 格式化输出的类
 * p291
 * Create by A-mdx at 2017/12/28 0:07
 * 
 * 这个也同样可以用于 String.format("%5s FFF %6d xxx %-12.2f OOO", "APPLE", 236, 15.8);
 * 类似上面这种格式化输出的
 */
public class December27Pro {
    double price = 0.0;
    Formatter formatter = new Formatter(System.out);

    @Test
    public void test1() {
        String.format("%5s FFF %6d xxx %-12.2f OOO", "APPLE", 236, 15.8);
        // -的意思是 😩 不要右对齐，左对齐
        formatter.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        // %5d 表示 最少占用5个位置的 数字
        formatter.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        // .15 这个 主要表示最大尺寸的
        formatter.format("%-15.15s %5d %10.2f\n", name, qty, price);
        price += price;
    }

    @Test
    public void test2() {
        print("Coco Cola", 2, 15.5);
        print("Jack's dog", 3, 6);
        print("NewBalance", 5, 1456.3);
    }

    @Test
    public void test3() {
        formatter.format("%-15s %5s %10.2f\n", "Tax", "", price * 0.06);
        formatter.format("%-15s %5s %10s\n", "", "", "-----");
        formatter.format("%-15s %5s %10.2f\n", "Total", "", price * 1.06);
    }
    
    @Test
    public void test4() {
        // 这几个好神奇，厉害了。第一次见
        // 看一个 16进制 转储工具
        byte[] data = readBinaryFile("D:\\workspaces\\java_learn\\learnEveryday\\target\\classes\\com\\m2017\\december\\December27Pro.class");
        System.out.println(format(data));
        // 第一次看到这结果，惊呆了
        /*
        00000: CA FE BA BE 00 00 00 35 00 BC 0A 00 08 00 6B 09 
        00010: 00 3E 00 6C 07 00 6D 09 00 6E 00 6F 0A 00 03 00 
        00020: 70 09 00 3E 00 71 08 00 72 07 00 73 08 00 74 0A 
        00030: 00 75 00 76 06 40 2F 99 99 99 99 99 9A 0A 00 77 
        00040: 00 78 0A 00 60 00 79 08 00 7A 08 00 7B 08 00 7C 
        ....
         */
    }

    private byte[] readBinaryFile(String s) {
        try (FileInputStream fileInputStream = new FileInputStream(s)) {
            
            return fileInputStream.readAllBytes();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String format(byte[] data){
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data){
            if (n%16 == 0){
                result.append(String.format("%05X: ", n));
            }
            result.append(String.format("%02X ", b));
            n++;
            if (n%16 == 0){
                result.append("\n");
            }
        }
        return result.toString();
    }

    @Test
    public void test5() {
        int a = 1;
        StringBuilder str = new StringBuilder();
        str.append(String.format("%05x: ", a));
        str.append(String.format("%05X: ", a));
        System.out.println(str);
        System.out.println("---------------------------------------");
        System.out.println(String.format("%05x: ", a));
        System.out.println(String.format("%05X: ", a));
    }
}
