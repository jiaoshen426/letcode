package com.jiaoshen.other.c24;

import com.jiaoshen.util.ArraysUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 窗口内最大值或最小值更新结构的实现
 * 假设一个固定大小为W的窗口，依次划过arr，
 * 返回每一次滑出状况的最大值
 * 例如，arr = [4,3,5,4,3,3,6,7], W = 3
 * 返回：[5,5,5,4,6,7]
 */
public class SlidingWindowMaxArray {


    public static int[] getMaxWindow(int[] arr, int w) {
        LinkedList<Integer> maxList = new LinkedList<>();
        int[] maxArray = new int[arr.length - w + 1];

        for (int i = 0; i < arr.length; i++) {
            while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[i]) {
                maxList.pollLast();
            }
            maxList.addLast(i);
            if (i+1 >= w){
				while (maxList.peekFirst() <= i -w){
                    maxList.pollFirst();
				}
                maxArray[i+1-w] = arr[maxList.peekFirst()];
			}
        }
        return maxArray;

    }


    public static void main(String[] args) {
       ArraysUtils.print(getMaxWindow(new int[]{4,3,5,4,3,3,6,7},3));

    }

}
