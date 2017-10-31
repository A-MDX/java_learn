package com.m2017.october;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 224. Basic Calculator
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 * Created by a-mdx on 2017/10/30.
 * 基础计算器，有点意思了。
 */
public class Octo30 {
    public int calculate(String s) {

        s = s.replace(" ", "");

        Queue<Integer> nums = new ArrayDeque<>();
        Queue<Character> fus = new ArrayDeque<>();
        Stack<Integer> kuos = new Stack<>();

        int index = 0;
        if (s.indexOf(index) != '-') {
            fus.add('+');
        }

        while (index < s.length()) {
            char temp = s.charAt(index);
            switch (temp) {
                case '(':
                    kuos.push(index);

                    break;
                case '+':

                    if (kuos.isEmpty()) {
                        fus.offer('+');
                    }
                    break;
                case '-':

                    if (kuos.isEmpty()) {
                        fus.offer('-');
                    }
                    break;
                case ')':

                    // 运用递归处理这个
                    int leftIndex = kuos.pop();
                    // 这是一个 括号内的运算结果。
                    int result = calculate(s.substring(leftIndex + 1, index));

                    String leftStr = s.substring(0, leftIndex);
                    String rightStr = s.substring(index + 1, s.length());

                    // index=?
                    index = leftIndex - 1 + (result + "").length();
                    if (result < 0 && leftStr.length() > 0) {
                        // 小于0，需要变号
                        char lastFu = leftStr.charAt(leftStr.length() - 1);
                        if ('+' == lastFu) {
                            // 若是 + 号
                            s = leftStr.substring(0, leftStr.length() - 1) + result + rightStr;
                        } else if ('-' == lastFu) {
                            // 若是 - 号
                            s = leftStr.substring(0, leftStr.length() - 1) + '+' + Math.abs(result) + rightStr;
                        }
                        index--;
                    } else {
                        s = leftStr + result + rightStr;
                    }

                    if (kuos.isEmpty()) {
                        nums.offer(result);
                    }
                    break;
                default:
                    //  括号内的不在加入
                    if (kuos.isEmpty()) {
                        int num = s.charAt(index) - '0';
                        while (index + 1 < s.length()) {
                            int tempC = s.charAt(index + 1);
                            if (tempC >= '0' && tempC <= '9') {
                                num = num * 10 + (tempC - '0');
                                index++;
                            } else {
                                break;
                            }
                        }
                        nums.offer(num);
                    }

            }
            index++;
        }
        int sum = 0;
        while (!nums.isEmpty()) {
            char fu = fus.poll();
            int num = nums.poll();
            switch (fu) {
                case '-':
                    sum -= num;
                    break;
                default:
                    // +
                    sum += num;
            }
        }

        return sum;
    }

    // 看看别人的想法

    /**
     * Simple iterative solution by identifying characters one by one. One important thing is that the input is valid, which means the parentheses are always paired and in order.
     * Only 5 possible input we need to pay attention:
     * <p>
     * digit: it should be one digit from the current number
     * '+': number is over, we can add the previous number and start a new number
     * '-': same as above
     * '(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
     * ')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.
     * Finally if there is only one number, from the above solution, we haven't add the number to the result, so we do a check see if the number is zero.
     * 这个想法，g感觉h还挺神奇
     *
     * @param s
     * @return
     */
    public int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();  //stack.pop() is the sign before the parenthesis
                result += stack.pop();  //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

    @Test
    public void test2() {
        System.out.println(calculate("(1-(3-4))"));
    }

    @Test
    public void test1() {
        String str = "1+2+(2+(5+1))";
        System.out.println(str.subSequence(7 + 1, 11));

        String str1 = str.substring(7, 11 + 1);
        System.out.println("str1:" + str1);

        String leftStr = str.substring(0, 7);
        System.out.println("leftStr:" + leftStr);

        String rightStr = str.substring(12, str.length());
        System.out.println("rightStr:" + rightStr);

        System.out.println(leftStr + "xx" + rightStr);


    }


}
