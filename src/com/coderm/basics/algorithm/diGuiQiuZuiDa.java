package com.coderm.basics.algorithm;

public class diGuiQiuZuiDa {
    public static void main(String[] args) {
        int[] a = {1, 8, 3, 4, 5, 6};
        int c = getMax(a, 0, a.length - 1);
        System.out.println(c);
    }

    public static int getMax(int[] arr, int l,int r) {
        if(l == r){
            return arr[l];
        }
        int mid = l + ((r-l) >> 1);
        int leftmax = getMax(arr,l,mid);
        int rightmax = getMax(arr,mid+1,r);
        return Math.max(leftmax,rightmax);
    }
}
