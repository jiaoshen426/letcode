package com.jiaoshen.study.sort;

import com.jiaoshen.study.sort.utils.SortUtils;
import com.jiaoshen.util.ArraysUtils;

import java.util.Arrays;

/**
 * 快速排序
 * @author jiaoshen
 * @date 2021/10/20-10:52
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] nums ={1,5,6,9,8,7,6};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static <E extends  Comparable<E>> void  sort(E[] nums){
        excuteSort(nums,0,nums.length-1);
    }

    public static <E extends  Comparable<E>> void excuteSort(E[] nums,int startPoint,int endPoint){

        if(startPoint >= endPoint ||endPoint >nums.length || startPoint<0){
            return;
        }
        int lessAndEqualIndex = startPoint;
        int lessIndex = startPoint;
        E pivot = nums[endPoint];
        for (int i = startPoint; i < endPoint; i++) {
            if(nums[i].compareTo(pivot)<=0){
                lessAndEqualIndex++;
                if((nums[i].compareTo(pivot)<0)){
                    SortUtils.swap(nums,i,lessIndex);
                    lessIndex++;

                }
            }

        }
        SortUtils.swap(nums,lessAndEqualIndex,endPoint);
        excuteSort(nums,startPoint,lessIndex-1);
        excuteSort(nums,lessAndEqualIndex+1,endPoint);




    }


}
