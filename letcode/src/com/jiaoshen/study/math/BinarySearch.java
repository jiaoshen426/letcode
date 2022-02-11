package com.jiaoshen.study.math;

import com.jiaoshen.util.ArraysUtils;

/**
 * 二分查找求最大值
 *
 * @author jiaoshen
 * @date 2022/2/10-21:29
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[]  a= ArraysUtils.generateRandomArray(10,100);
        ArraysUtils.print(a);
        System.out.println("max num:"+process(a,0,a.length-1));



    }

    public static final int process(int[] a, int l, int r) {
        if (l >= r) {
            return a[l];
        }
        int left = process(a,l,(int)(l+r)/2);
        int right = process(a,(int)(l+r)/2+1,r);
        return Math.max(left,right);

    }


}
