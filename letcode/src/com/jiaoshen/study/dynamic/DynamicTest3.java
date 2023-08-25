package com.jiaoshen.study.dynamic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个数组arr，arr[i]代表第i号咖啡机泡一杯咖啡的时间
 * 给定一个正数N，表示N个人等着咖啡机泡咖啡，每台咖啡机只能轮流泡咖啡
 * 只有一台咖啡机，一次只能洗一个杯子，时间耗费a，洗完才能洗下一杯
 * 每个咖啡杯也可以自己挥发干净，时间耗费b，咖啡杯可以并行挥发
 * 假设所有人拿到咖啡之后立刻喝干净，
 * 返回从开始等到所有咖啡机变干净的最短时间
 * 三个参数：int[] arr、int N，int a、int b
 *
 * @author jiaoshen
 * @date 2023-07-29-12:53
 */
public class DynamicTest3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,7};
        System.out.println("result========"+ process(arr,8,0,0));
    }
    static class CoffeeMachine {
        private int startTime;
        private int costTime;

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getCostTime() {
            return costTime;
        }

        public void setCostTime(int costTime) {
            this.costTime = costTime;
        }

        public CoffeeMachine(int startTime, int costTime) {
            this.startTime = startTime;
            this.costTime = costTime;
        }
    }


    static int process(int[] arr, int N, int a, int b) {
        Comparator<CoffeeMachine> machineComparator = Comparator.comparingInt(o -> (o.startTime + o.getCostTime()));
        Queue<CoffeeMachine> queue = new PriorityQueue(machineComparator);

        for (int i : arr) {
            queue.add(new CoffeeMachine(0,i));
        }
        for (int n = N; n > 0; n--) {
            CoffeeMachine chose =  queue.poll();
            System.out.println(chose.costTime);
            chose.startTime += chose.costTime;
            queue.add(chose);
        }
        int result =0;
        while (!queue.isEmpty()) {
            CoffeeMachine coffeeMachine = queue.poll();
            result = coffeeMachine.getCostTime()+coffeeMachine.startTime;
        }
        return result;
    }




    private int getMinOfTheArr(int[] arr) {
        int index = 0;
        int min = arr[0];
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < min) {
                index = i;
            }
        }
        return index;
    }


}
