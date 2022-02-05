package com.jiaoshen.study.sort;

import com.jiaoshen.study.sort.utils.SortUtils;

import java.util.Arrays;

/**
 * 选择排序
 * 每次拿最小的，下一步拿剩下最小的，直到最后一个
 * O(n*n)
 */
public class SelectionSort {
    public static void main(String[] args) {
        Integer[] nums ={1,5,6,9,8,7,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static <E extends  Comparable<E>> void  sort(E[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j].compareTo(nums[i]) <0 ){
                    SortUtils.swap(nums,i,j);
                }
            }
        }
    }
}
