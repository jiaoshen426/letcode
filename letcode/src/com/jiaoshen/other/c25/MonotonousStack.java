package com.jiaoshen.other.c25;

import com.jiaoshen.util.ArraysUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 找出两边离最近又比它小的数（无重复数+有重复数）
 * 单调栈
 */
public class MonotonousStack {

    // arr = [ 3, 1, 2, 3]
    //         0  1  2  3
    //  [
    //     0 : [-1,  1]
    //     1 : [-1, -1]
    //     2 : [ 1, -1]
    //     3 : [ 2, -1]
    //  ]
    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            while (!stack.isEmpty() && now < arr[stack.peek()] ){
                int pop = stack.pop();
                res[pop][1] = i;
                if(!stack.isEmpty()){
                    res[pop][0] = stack.peek();
                }else{
                    res[pop][0] = -1;
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty() ){
            int pop = stack.pop();
            if(!stack.isEmpty()){
                res[pop][0] = stack.peek();
            }else{
                res[pop][0] = -1;
            }
            res[pop][1] = -1;
        }
        return res;
    }

    public static int[][] getNearLess(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<List<Integer>> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            while (!stack.isEmpty() && now < arr[stack.peek().get(0)] ){
                List<Integer> popList = stack.pop();
                int leftLessIndex =stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
                for (Integer pop : popList) {
                    res[pop][0] =leftLessIndex;
                    res[pop][1] = i;
                }
            }

            if(!stack.isEmpty() && Integer.valueOf(arr[stack.peek().get(0)]).equals(arr[i])){
                stack.peek().add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }

        while (!stack.isEmpty() ){
            List<Integer> popList = stack.pop();
            int leftLessIndex =stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
            for (Integer pop : popList) {
                res[pop][0] =leftLessIndex;
                res[pop][1] = -1;
            }
        }
        return res;

    }

    // for test


    // for test
    public static int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

    // for test


    // for test
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 10;
        int max = 20;
        int testTimes = 200;
        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {
            int[] arr1 = ArraysUtils.getRandomArrayNoRepeat(size);
           // printArray(arr1);
            if (!ArraysUtils.isEqual(getNearLessNoRepeat(arr1), rightWay(arr1))) {
                System.out.println("Oops!");
                printArray(arr1);
                break;
            }
            int[] arr2 = ArraysUtils.generateRandomArray(size, max);
            if (!ArraysUtils.isEqual(getNearLess(arr2), rightWay(arr2))) {
                System.out.println("Oops!");
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }
}
