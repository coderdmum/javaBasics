package com.coderm.basics.javaBasics.day01.array;

/*
创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同

获取[a，b]范围的随机数： (int)(Math.random()*(b-a+1)) +a
*/

public class RandomArray {
     public static void main(String[] args) {

          Cal(6);
     }

     public static void Cal(int n) {
          int[] arr = new int[n];
          for (int i = 0; i < arr.length; i++) {// [0,1) [0,30) [1,31)
               arr[i] = (int) (Math.random() * 30) + 1;

               for (int j = 0; j < i; j++) {
                    if (arr[i] == arr[j]) {
                         i--;
                         break;
                    }
               }
          }
          for (int i = 0; i < arr.length; i++) {
               System.out.println(arr[i]);
          }
     }
}
