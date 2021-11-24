package com.coderm.basics.javaBasics.day01.array;

public class huiXingShu {
    public static void main(String[] args) {
        Cal(6);

    }
    public static void Cal(int n) {
        int[][] arr = new int[n][n];
        int num = 1;

        // 外层循环 i 控制圈数,内层循环 j 控制第几条线
        for (int i = 0; i < n / 2; i++) {
            // 第一条线 上线
            // x 表示列， y 表示行
            for (int y = i, x = i; x < n - i - 1; x++) {
                arr[y][x] = num++;
            }
            // 第二条线 右线
            for (int y = i, x = n - i - 1; y < n - i - 1; y++) {
                arr[y][x] = num++;
            }
            // 第三条线 下线
            for (int y = n - i - 1, x = n - i - 1; x > i; x--) {
                arr[y][x] = num++;
            }
            // 第四条线 左线
            for (int y = n - i - 1, x = i; y > i; y--) {
                arr[y][x] = num++;
            }
        }
        // 对输入的阶数进行判断
        if (n % 2 == 1) {
            arr[n / 2][n / 2] = num;
        }
        // 遍历打印输出数字
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
