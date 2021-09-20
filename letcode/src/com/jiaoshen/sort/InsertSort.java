package com.jiaoshen.sort;

import com.jiaoshen.sort.utils.SortUtils;

import java.util.Arrays;

/**
 * 跟打牌一样，拿到新的一张就插进去
 * 插入排序法
 */
public class InsertSort
{
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
