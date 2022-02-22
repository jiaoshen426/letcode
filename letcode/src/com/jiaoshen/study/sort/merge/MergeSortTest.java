package com.jiaoshen.study.sort.merge;

import com.jiaoshen.util.ArraysUtils;

/**
 * 归并排序练习题  求数组中每个数最右标小于自己的数之和并累加
 *
 * @author jiaoshen
 * @date 2022/2/11-16:46
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int[] nums ={1,5,6,9,8,7,6};
        sort(nums);
        ArraysUtils.print(nums);


    }

    public static final void  sort(int[] nums){
        process(nums,0,nums.length-1);
    }
    public static final void   process(int[] nums,int left ,int right){
        if(left >= right){
            return;
        }
        int mid = (right +left)>>1;
        process(nums,left,mid);
        process(nums,mid+1,right);
        int left1Index = left;
        int left2Index = mid+1;
        //两个有序数组排序
        int[] temp = new int[right-left+1];
        for(int i = 0; left1Index<=mid ||left2Index<=right ;i++){
            if(left1Index>mid){
                temp[i]=nums[left2Index];
                left2Index++;
            }else if(left2Index > right){
                temp[i]=nums[left1Index];
                left1Index++;
            }else{
                if(nums[left1Index] >=nums[left2Index]){
                    temp[i]=nums[left1Index];
                    left1Index++;
                }else{
                    temp[i]=nums[left2Index];
                    left2Index++;
                }
            }
        }
        for(int j = left;j<=right;j++){
            nums[j] =temp[j-left];
        }
    }
}
