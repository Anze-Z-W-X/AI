package com.anze.ai3.utils;

import java.util.Random;

public class Utils {
    //洗牌
    public static int[][] shuffle(int[][] arr) {
        int length = arr.length;
        Random rand = new Random();
        for ( int i = length; i > 0; i-- ){
            int randInd = rand.nextInt(i);
            swap(arr, randInd, i - 1);
        }
        return arr;
    }
    public  static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //找到最小值的索引
    public  static int minValueIndex(int[]arr){
        int []temp = copy(arr);
        int n = arr.length;
        int pos = 0;
        int min = temp[0];
        if (n>1){
            for (int i =1;i<n;i++){
                if (temp[i]<min){
                    min = temp[i];
                    pos = i;
                }
            }
        }
        return pos;
    }
    public static void print(int[][]arr) {
        /* int[][] arr = {{31 41 25 30},
                            {19 55 3 34},
                            {23 42 27 6},
                            {13 22 14 13},
                            {33 5 57 19}}
        */
        int x = arr.length;
        int y = arr[0].length;

        for (int m = 0; m < x; m++) {
            for (int n = 0; n < y; n++) {
                System.out.print(arr[m][n] + " ");
            }
            System.out.println("------");
        }
    }
    public static int[][] copy(int[][]arr){
        int[][]brr=new int [arr.length][arr[0].length];
        for(int i = 0;i<arr.length;i++)
        {
            for(int j= 0 ;j<arr[i].length;j++)
            {
                brr[i][j] = arr[i][j];
            }
        }
        return brr;
    }
    public static int[] copy(int[]arr){
        int [] temp = new int[arr.length];
        for (int i = 0;i< arr.length;i++){
            temp[i]=arr[i];
        }
        return temp;
    }
}