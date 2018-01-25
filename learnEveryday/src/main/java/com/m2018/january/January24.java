package com.m2018.january;

import org.junit.Test;

import java.io.*;

/**
 * 好久没有来看看我的 java 编程思想 了
 * Create by A-mdx at 2018-01-24 23:11
 */
public class January24 {
    public static void main(String... args) {
        String regex = ".java";
        File path = new File("D:\\workspaces\\java_learn\\learnEveryday\\src\\main\\java\\com\\m2018\\january");
        // FilenameFilter
        // 不得不说，1.8 的java 跟以前的java ，简直进化太大了
        String[] list = path.list((dir, name) -> name.endsWith(regex));
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("==========================================================");
        list = path.list((dir, name) -> {
            return name.matches("[A-Z]+[a-zA-Z0-9]+.java");
//            return name.contains("Pro");
        });
        for (String s : list) {
            System.out.println(s);
        }
        
    }
    
    @Test
    public void test1(){
        File file = new File("D:\\workspaces\\java_learn\\learnEveryday\\src\\main\\java\\com\\m2018\\january\\January24.java");
//        System.out.println(File.pathSeparatorChar);
        System.out.println(file.lastModified());
        System.out.println(file.getParent());
    }

    /**
     * 复习一下当初所学的这个知识，没想到啊
     * 再也用不着这个方法了。
     */
    @Test
    public void test2() {
        File file = new File("D:\\workspaces\\java_learn\\learnEveryday\\src\\main\\java\\com\\m2018\\january\\January24.java");
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            System.out.println(randomAccessFile.length());
            System.out.println(randomAccessFile.getFilePointer());
            System.out.println(randomAccessFile.readLine());
            
            randomAccessFile.seek(1000L);
            System.out.println(randomAccessFile.readLine());
            System.out.println(randomAccessFile.readLine());
            
            System.out.println(randomAccessFile.getFilePointer());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这玩意 输出出来的东西，简直奇葩
     */
    @Test
    public void test3() {
        File file = new File("D:\\workspaces\\java_learn\\learnEveryday\\src\\main\\java\\com\\m2018\\january\\January24.java");
        try (DataInputStream in = new DataInputStream(new FileInputStream(file))) {
            int num;
            while ((num = in.available()) > 0) {
                System.out.print((char) in.readByte());
                if (num % 100 == 0) {
                    System.out.println("\n------------(" + num + ")-----------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
