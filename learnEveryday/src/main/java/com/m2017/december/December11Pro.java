package com.m2017.december;

/**
 * some exceting things...
 * 这个就感觉非常奇葩了，如果覆盖了父类构造器中所用到的方法，子类首先构造父类会调用自己的方法
 * 这可能是个坑
 * Create by A-mdx at 2017/12/11 23:14
 * 书上写：尽量少调用方法来构造对象，尽量不要内含方法。
 */
public class December11Pro {
    public static void main(String... args) {
        Food food = new Food();
        System.out.println("------------------------------------------------------------");
        Orange orange = new Orange();

        System.out.println("done.");
        /*
I am eating food................
Food is done...
------------------------------------------------------------
I am eating orange...............
There has 0 oranges...
Food is done...
Orange is done.....
done.
         */
    }
}

class Food {
    void eat() {
        System.out.println("I am eating food................");
    }

    Food() {
        eat();
        System.out.println("Food is done...");
    }
}

class Orange extends Food {
    int number = 9;

    Orange() {
        System.out.println("Orange is done.....");
    }

    void eat() {
        System.out.println("I am eating orange...............");
        // 父类会调用这个方法，然而其中的结果还没没有完成初始化
        System.out.println("There has " + number + " oranges...");
    }
}
