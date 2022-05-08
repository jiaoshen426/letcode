package com.jiaoshen.test;

import java.util.Arrays;

/**
 * @author jiaoshen
 * @date 2022/2/5-16:39
 */
public class Test2 {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 2, 3, 1};
//        System.out.println(reversePairs(nums));
        System.out.println("".split(",").length);
    }


    public static int reversePairs(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private static int process(int a[], int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = (right + left) >> 1;
        return process(a, left, mid) + process(a, mid + 1, right) + merge(a, left, right, mid);
    }

    private static int merge(int a[], int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        //临时数组下标
        int i = 0;
        int indexLeft = left;
        int indexRight = mid + 1;
        int result = 0;
        while (indexLeft <= mid || indexRight <= right) {
            if (indexLeft > mid) {
                temp[i++] = a[indexRight++];
            } else if (indexRight > right) {
                temp[i++] = a[indexLeft++];
            } else {
                if (a[indexLeft] > (a[indexRight] *2)) {

                    result += (right - indexRight + 1);
                    temp[i++] = a[indexLeft++];
                } else {
                    temp[i++] = a[indexRight++];
                }
            }
        }
        for (int j = 0; j <= right - left; j++) {
            a[j + left] = temp[j];
        }
        return result;
    }

}
