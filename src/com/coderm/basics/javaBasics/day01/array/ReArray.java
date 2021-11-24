package com.coderm.basics.javaBasics.day01.array;

import java.util.Arrays;
/*
一维数组a[]，用java代码将数组元素顺序颠倒

获取[a，b]范围的随机数： (int)(Math.random()*(b-a+1)) +a
 */

public class ReArray {
    public static void main(String[] args) {
        product(5);
    }

    public static void product(int n) {
        int [] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() *1000);

        }

        System.out.println(arr);
        System.out.println(Arrays.toString(arr));
        swap(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int a[]) {
        int len = a.length;
        for (int i = 0; i < len / 2; i++) {
            int tmp = a[i];
            a[i] = a[len - 1 - i];
            a[len - 1 - i] = tmp;
        }
    }

}
