package com.coderm.basics.algorithm.softBasics;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 2, 3, 9, 27, 11};

        smallBig(arr);
        bigSmall(arr);


    }

    public static void smallBig(int[] arr) {
        //冒泡,x小到大
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void bigSmall(int[] arr) {
        //冒泡,x大到小
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j]<arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
