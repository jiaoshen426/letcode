package com.jiaoshen.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author jiaoshen
 * @date 2021/10/20-10:54
 */
public class MergeSort {

    public static void main(String[] args) {
        Integer[] nums ={1,5,6,9,8,7,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static <E extends  Comparable<E>> void  sort(E[] nums){
        for (int i = 1; i < nums.length; i++) {
            E temp = nums[i];
            for (int j = i;  j-1>0; j--) {
                if(nums[j-1].compareTo(temp) >0){
                    nums[j] = nums[j-1];
                }else{
                    nums[j] = temp;
                    break;
                }
            }
        }
    }
}
