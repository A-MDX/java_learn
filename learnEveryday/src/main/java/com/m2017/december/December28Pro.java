package com.m2017.december;

import org.junit.Test;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 今天学习一下 正则表达式
 * p296
 * Create by A-mdx at 2017/12/28 11:39
 */
public class December28Pro {

    @Test
    public void test3() throws IOException {
        // 还是书上的题
        // 打印所有 字符串，我加工一下，干脆 对比一下 每个单词的 多少
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File("D:\\workspaces\\java_learn\\learnEveryday\\src\\main\\java\\com\\m2017\\december\\December28Pro.java")))) {

            // 匹配字符数字
            Pattern pattern = Pattern.compile("\\w+");
            Matcher matcher = pattern.matcher("");
            Map<String, Integer> numbers = new LinkedHashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                matcher.reset(line);
                line = matcher.replaceFirst("test");
                // 看来这个会不停地找下去，直到找不到为止。 若传递参数，会使其 从传入index 开始查找
                while (matcher.find()) {
                    String key = matcher.group();
                    numbers.computeIfPresent(key, (k, v) -> ++v);
                    numbers.putIfAbsent(key, 1);
                }
            }

            numbers.forEach((k, v) -> System.out.println(k + " : " + v));
        }
    }

    @Test
    public void test2() throws IOException {
        // 看到书上有一道题：
        // 编写一道程序，读取一个java 源代码文件，打印出 所有的注释
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File("D:\\workspaces\\java_learn\\learnEveryday\\src\\main\\java\\com\\m2017\\december\\December27Pro.java")))) {
            String line = null;
            boolean dian2Flag = false;
            boolean dian1Flag = false;
            while ((line = reader.readLine()) != null) {
                if (dian2Flag) {
                    System.out.println(line.trim());
                    if (line.contains("*/")) {
                        dian2Flag = false;
                    }
                } else if (dian1Flag) {
                    System.out.println(line.trim());
                    if (line.contains("*/")) {
                        dian1Flag = false;
                    }
                } else if (line.contains("//")) {
                    System.out.println(line.trim());
                } else if (line.contains("/**")) {
                    System.out.println(line.trim());
                    dian2Flag = true;
                } else if (line.contains("/*")) {
                    System.out.println(line.trim());
                    dian1Flag = true;
                }

            }
        }
    }

    @Test
    public void test1() {
        System.out.println("\"-1234\".matches(\"-?\\\\d+\"): "
                // -? 表示可能会有 这个 ‘-' 出现， \d 表示数字, '+' 表示可能多次出现，不然就是一次
                + "-1234".matches("-?\\d+"));

        System.out.println("\"5678\".matches(\"-?\\\\d+\"): "
                // ? 表示可能会出现啊        
                + "5678".matches("-?\\d+"));

        System.out.println("\"+7894\".matches(\"-?\\\\d+\"): "
                //
                + "+7894".matches("-?\\d+"));

        System.out.println("\"+7894\".matches(\"(-|\\\\+)?\\\\d+\"): "
                // '|' 这个表示 或者 的 意思啊
                + "+7894".matches("(-|\\+)?\\d+"));

        // \w 匹配单词  \W 匹配非单词
    }

    public static void main(String... args) {
        // 测试一下 main 方法接收参数
        System.out.println("main 开始接收参数------");

        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("done...................");
    }
    /*
     java com/m2017/december/December28Pro 456 zxc 78qeqw qwe789 qw
e789a qwe7c54 ad456 asdaaa 666
main 开始接收参数------
456
zxc
78qeqw
            qwe789
    qwe789a
            qwe7c54
    ad456
            asdaaa
666
    done...................
            */
}
