package com.jiaoshen.study.sort.merge;

import java.util.Arrays;

/**
 *
 * 归并排序练习题
 * 1.小和问题 ，求数组中每个数最右标小于自己的数之和并累加
 * 2.逆序对计算
 *
 * @author jiaoshen
 * @date 2022/3/27-17:56
 */
public class MergeSortQ1 {
    public static void main(String[] args) {
        int[] nums ={6,1,2,3,6,7};
        System.out.println(process(nums,0, nums.length-1));
    }

    private static int process(int a[], int left, int right) {
        if (left >= right) {
            return 0;
        }
        System.out.println("left"+left+"right:"+right);
        int mid = (right + left) >> 1;
        return process(a, left, mid) + process(a, mid + 1, right) + merge2(a, left, right, mid);
    }

    /**
     * 左小值累加之和
     * @param a
     * @param left
     * @param right
     * @param mid
     * @return
     */
    private static int merge(int a[], int left, int right, int mid) {
        int[] temp =new int[right-left+1];
        //临时数组下标
        int i = 0;
        int indexLeft = left;
        int indexRight = mid+1;
        int result = 0;
        while(indexLeft<=mid ||indexRight<=right){
            if(indexLeft >mid){
                temp[i++] = a[indexRight++];
            } else if(indexRight >right){
                temp[i++] = a[indexLeft++];
            }else{
                if(a[indexLeft] <a[indexRight]){
                    result+=a[indexLeft]*(right-indexRight+1);
                    temp[i++] =  a[indexLeft++];
                }else{
                    temp[i++] =  a[indexRight++];
                }
            }
        }
        for(int j=0;j<=right-left;j++ ){
            a[j+left] = temp[j];
        }
        return result;
    }

    /**
     * 2.逆序对
     *
     * @param a
     * @param left
     * @param right
     * @param mid
     * @return
     */
    private static int merge2(int a[], int left, int right, int mid) {
        int[] temp =new int[right-left+1];
        //临时数组下标
        int i = 0;
        int indexLeft = left;
        int indexRight = mid+1;
        int result = 0;
        while(indexLeft<=mid ||indexRight<=right){
            if(indexLeft >mid){
                temp[i++] = a[indexRight++];
            } else if(indexRight >right){
                temp[i++] = a[indexLeft++];
            }else{
                if(a[indexLeft] >a[indexRight]*2){
                    result++;
                    temp[i++] =  a[indexLeft++];
                }else{
                    temp[i++] =  a[indexRight++];
                }
            }
        }
        for(int j=0;j<=right-left;j++ ){
            a[j+left] = temp[j];
        }
        return result;
    }
}
