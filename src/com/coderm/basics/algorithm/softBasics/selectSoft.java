package com.coderm.basics.algorithm.softBasics;


/**
 * @author
 * @Description ѡ������
 * @date
 */
public class selectSoft {
    public static void main(String[] args) {
        //ģ������
        int[] array = {52,63,14,59,68,35,8,67,45,99};
        System.out.println("ԭ���飺");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        selectSort(array);
        System.out.println("�����");
        for (int i = 0; i < array.length; i++) {
            System.out.print(i+" ");
        }
    }

    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j <arr.length ;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                swap(arr, i, min);
            }
        }
    }
    //���������Ԫ�ؼ佻��
    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
