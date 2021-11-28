package com.coderm.basics.javaBasics.day01.array;

/**
 * ���ֲ���ǰ������
 */
public class BinarySearch {
    public static void main(String[] args) {
         int arr[] = new int[]{-1, 22 ,33 ,44 ,55, 66};
         int find = 22; //�����ҵ�����
         Boolean isfind = true;
         int head = 0;
         int end = arr.length-1;
         while(head <= end) {

             int middle = (head+end)/2;
             if (find == arr[middle]) {
                 System.out.println("success, location is:"+middle);
                 isfind = false;
                 break;
             }else if (arr[middle] > find) {
                 end = middle-1;
             }else {
                 head = middle +1;
             }
         }
         if (isfind) {
             System.out.println("fail");
         }

    }
}
