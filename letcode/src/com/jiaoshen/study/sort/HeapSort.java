package com.jiaoshen.study.sort;

import com.google.common.collect.MinMaxPriorityQueue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
