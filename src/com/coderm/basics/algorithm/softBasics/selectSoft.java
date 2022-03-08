package com.coderm.basics.algorithm.softBasics;

import java.util.Arrays;

/**
 * @author
 * @Description 选择排序
 * @date
 */
public class selectSoft {
    public static void main(String[] args) {
        int[] arr = {2,6,8,4,1};
        int min;
        int temp;
        int j;
        for(int i=0;i<arr.length-1;i++) {
            min=i;  //假设该下标为最小值的下标
            j=i;
            for(;j<arr.length;j++) {
                if(arr[min]>arr[j]) {  //选取最小值,得到最小值得下标
                    min=j;
                }
            }
            //进行交换
            temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
            System.out.printf("第%d次排序的结果是： \n",i+1);
            System.out.println(Arrays.toString(arr));
        }
    }
}
