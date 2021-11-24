package com.coderm.basics.algorithm;
/*
给定一个数组arr和一个数num，
请把小于等于num是数放在数组的左边大于num是数放在数组的右边，
要求额外空间为o(1),时间为o(n)
例如：
arr={4,5,6,7,5,1,2,5}
num=5
输出
0, 0, 5, 1, 2, 5, 6, 7
*/

import java.util.Arrays;
public class NewHeLan {
    public static void main(String[] args){
        int[] arr={4,5,6,7,5,1,2,5};
        rotate(arr,5);
        System.out.println(Arrays.toString(arr));
    }
    static void rotate(int[] arr,int num){
        if(arr==null||arr.length<=0)return;
        int left=-1,current=0,len=arr.length;
        while (current<len){
            if(arr[current]<=num){
                left++;
                swap(arr,left,current);
                current++;
            }
            else {
                current++;
            }
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
