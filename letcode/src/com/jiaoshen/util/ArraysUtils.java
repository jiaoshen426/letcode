package com.jiaoshen.util;

import java.util.Arrays;

/**
 * @author jiaoshen
 * @date 2022/2/5-15:04
 */
public class ArraysUtils {
    /**
     * 交换数组
     * @param a
     * @param x
     * @param y
     */
     public static void swap(int[] a,int x,int y){
         if(x!=y){
             a[x]= a[x]^a[y];
             a[y]=a[x]^a[y];
             a[x]=a[x]^a[y];
         }
     }

    /**
     * 打印數組
     * @param a
     */
     public static void  print(int[] a){
         System.out.println(Arrays.toString(a)) ;
     }

    /**
     * 生成随机数组（正整数）
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) ;
        }
        return arr;
    }

    /**
     * 数组复制
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //数值验证相等
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }





}
