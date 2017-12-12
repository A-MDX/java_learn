package com.m2017.december;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * 今天来看某个牛叉的实现，来自 thinking in java...
 * Create by A-mdx at 2017/12/13 0:34
 */
public class December13 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(new AdaptedDoubleReadable(5));
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}

// 小数产生器
class RandomDouble {
    Random random;

    RandomDouble() {
        random = new Random();
    }

    double next() {
        return random.nextDouble();
    }
}

// 使用适配器模式
class AdaptedDoubleReadable extends RandomDouble implements Readable {
    int count;

    AdaptedDoubleReadable(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count == 0) {
            return -1;
        }
        count--;
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }
}
