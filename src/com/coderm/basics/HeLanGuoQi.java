package com.coderm.basics;
//给定一个数组arr和一个数num，请把小于num是数放在数组的左边，
//        等于num的数放在数组的中间，
//        大于num是数放在数组的右边，要求额外空间为o(1),时间为o(n)
//        例如：
//        arr={4,5,6,7,5,1,2,3}
//        num=5
//        输出
//        0, 3, 2, 1, 5, 5, 7, 6


import java.util.Arrays;

public class HeLanGuoQi {
    public static void main(String[] args){
        int[] arr={4,5,6,7,5,1,2,3};
        rotate(arr,5);
        System.out.println(Arrays.toString(arr));
    }
    static void rotate(int[] arr,int num){
        if(arr==null||arr.length<=0)return;
        int left=-1,right=arr.length,current=0;
        while (current<right){
            if(arr[current]<num){
                left++;
             swap(arr,left,current);
             current++;
            }
            else if(arr[current]==num){
                current++;
            }else {
                right--;
                swap(arr,current,right);
            }
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
