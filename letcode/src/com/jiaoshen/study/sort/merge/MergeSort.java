package com.jiaoshen.study.sort.merge;

import java.lang.reflect.Array;
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
         excuteSort(nums,0,nums.length-1);
    }

    public static <E extends  Comparable<E>> void  excuteSort(E[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int mid = (l+r)>>1;
        excuteSort(nums,l,mid);
        excuteSort(nums,mid+1,r);
        merge(nums,l,r,mid);



    }

    /**
     * 递归实现归并算法
     * @param nums
     * @param l
     * @param r
     * @param mid
     * @param <E>
     */
    public static <E extends  Comparable<E>> void merge(E[] nums,int l, int r ,int mid){
        int index1  =l;
        int index2 = mid+1;
        int newArrayIndex =l;
        Object[] temp = new Object[nums.length] ;
        while (index1<=mid || index2<=r ){
            if(index1>mid){
                temp[newArrayIndex] = nums[index2];
                index2++;
            }else  if(index2>r){
                temp[newArrayIndex] = nums[index1];
                index1++;
            }else{
                temp[newArrayIndex] = nums[index1].compareTo(nums[index2])>0?nums[index1++]:nums[index2++];
            }
            newArrayIndex++;
        }
        for (int i = l; i <= r; i++) {
            nums[i] = (E)temp[i];
        }
    }


}
