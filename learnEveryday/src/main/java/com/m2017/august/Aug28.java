package com.m2017.august;

import org.junit.Test;

/**
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 * Created by a-mdx on 2017/8/28.
 * https://leetcode.com/problems/add-two-numbers/description/
 * 链表 + 算法，无语
 * 这个算法，这个丑陋的解法，我也是醉了
 */
public class Aug28 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder ll1 = new StringBuilder();

        while (l1 != null){
            ll1.insert(0, l1.val);
            l1 = l1.next;
        }
        java.math.BigInteger n1 = new java.math.BigInteger(ll1.toString());
//        long n1 = Long.parseLong(ll1.toString());
        System.out.println("n1 : " + n1.toString());

        StringBuilder ll2 = new StringBuilder();

        while (l2 != null){
            ll2.insert(0, l2.val);
            l2 = l2.next;
        }
        java.math.BigInteger n2 = new java.math.BigInteger(ll2.toString());

        System.out.println("n2 : " + n2);
        java.math.BigInteger sum = n1.add(n2);

        char[] arr = (sum.toString()).toCharArray();
        ListNode root = new ListNode(arr[arr.length -1] - '0');

        ListNode temp = root;
        for (int i = arr.length -2; i >= 0; i--) {
            temp.next = new ListNode(arr[i] - '0');
            temp = temp.next;
        }

        return root;
    }

    @Test
    public void test1(){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(addTwoNumbers(l1, l2));
    }

    @Test
    public void name() throws Exception {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);


        ListNode l2 = new ListNode(0);


        System.out.println(l1);
        System.out.println(l2);
        System.out.println(addTwoNumbers(l1, l2));
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
        }

        @Override
        public String toString() {
            String str = val + "";
            if (next != null){
                str += " -> " +next.toString();
            }
            return str;
        }
    }
}
