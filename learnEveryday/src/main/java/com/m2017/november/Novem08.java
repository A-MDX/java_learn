package com.m2017.november;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://visualgo.net/en/sorting
 * 今天看着 插入排序的意识图，想自己写写，练练手
 * Created by a-mdx on 2017/11/8.
 */
public class Novem08 {

    public void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            // 将当前要插入值的 下标拿出来
            int index = i;
            for (int j = i-1; j >= 0; j--) {
                // 如果左边大于右边，直接交换，一直交换下去，否则直接跳出。
                if (arr[index] < arr[j]){
                    // 交换
                    int temp = arr[index];
                    arr[index] = arr[j];
                    arr[j] = temp;

                    index--;

                }else {
                    break;
                }
            }
        }
    }

    @Test
    public void test1(){
        int[] arr = {3,1,9,0,8,4,2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
