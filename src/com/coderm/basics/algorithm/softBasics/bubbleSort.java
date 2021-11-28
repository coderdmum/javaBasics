package com.coderm.basics.algorithm.softBasics;

/**
 * √∞≈›≈≈–Ú
 */
public class bubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5, 10, 2, 3, 9, 27, 11};


        //√∞≈›,x–°µΩ¥Û
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i] + "\t");
        }

    }
}
