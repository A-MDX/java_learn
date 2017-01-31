package tests;

import java.util.Scanner;

/**
 * Created by A-mdx on 2017/1/31.
 */
public class GuessNum {

    public static void main(String[] args) {
        final int num = (int) (Math.random()*100+1);
        System.out.println("范围是1-100。");
        System.out.println("来，输入一个数字：");
        Scanner scanner = new Scanner(System.in);
        
        int b = 1;
        
        int a = 1;
        while (true){
            try {
                a = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("You enter a bad num.");
                e.printStackTrace();
                break;
            }
            if (a == num ){
                System.out.println("good! ^_^");
                break;
            }else if(a > num){
                System.out.println("It's too big.");
            }else {
                System.out.println("It's toot small.");
            }
            b++;

        }
        System.out.println("猜的次数是:"+b);
        System.out.println("Bye bye.");
    }
    
}
