package com.jiaoshen.study.sort;

import java.util.PriorityQueue;

/**
 * 堆排序
 * 
 * @author jiaoshen
 * @date 2022/5/28-14:54
 */
public class HeapSort {
    public static void main(String[] args) {


        PriorityQueue<Integer> heaps = new PriorityQueue<>();
        heaps.add(15);
        heaps.add(17);
        heaps.add(8);

        while (heaps.size()>0){
            System.out.println(heaps.poll());
        }



    }



}
