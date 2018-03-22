package com.m2018.march;

import org.junit.Test;

import java.util.Arrays;

/**
 * 各种排序
 * Create by A-mdx at 2018-03-21 18:15
 */
public class AllSorts {

    @Test
    public void test1() {
        int[] arr = {7, 5, 6, 3, 9, 1, 4, 2};
//        bubbleSort(arr);
//        selectSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 希尔排序，额，算是学习吧
     * 这个有点难
     * @param arr
     */
    public void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j-gap]){
                    swap(arr, j, j-gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 选择排序，
     * 回想起当初，老师叫我们写冒泡排序，我没想出来冒泡，写了个当时不知道啥的排序。
     * 如今想想，就是这个了，选择排序。
     *
     * @param arr
     */
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    /**
     * 冒泡排序
     */
    public void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
