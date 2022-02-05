package com.jiaoshen.study.sort.utils;

public class SortUtils {
    /**
     * 数组位置交换
     * @param a
     * @param index1
     * @param index2
     */
    public static <E>  void swap(E[] a, int index1, int index2){
        E temp = a[index1];
        a[index1] = a[index2];
        a[index2] =temp;
    }
}
