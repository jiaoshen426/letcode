package com.jiaoshen.study.recursion;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 给定一个正数数组arr，
 * 请把arr中所有的数分成两个集合，尽量让两个集合的累加和接近
 * 返回最接近的情况下，较小集合的累加和
 *
 * @author jiaoshen
 * @date 2023-08-19-12:37
 */
public class SplistNumClosed {
    private static int quest(int[] list) {
        if (list == null && list.length < 2) {
            return 0;
        }
        int limit = IntStream.of(list).sum() / 2;
        return process(list, 0, limit);
    }

    private static int dp(int[] list) {
        if (list == null && list.length < 2) {
            return 0;
        }
        int limit = IntStream.of(list).sum() / 2;
        int dp[][] = new int[list.length + 1][limit + 1];
        for (int index = list.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= limit; rest++) {
                int noPick = dp[index + 1][rest];
                int pick = 0;
                if (rest >= list[index]) {
                    pick =list[index] + + dp[index + 1][rest - list[index]];
                }
                dp[index][rest]=Math.max(noPick, pick);
            }
        }


        return dp[0][limit];
    }

    private static int process(int[] list, int index, int rest) {
        if (index == list.length) {
            return 0;
        }
        int noPick = process(list, index + 1, rest);
        int pick = 0;
        if (rest >= list[index]) {
            pick = list[index] + process(list, index + 1, rest - list[index]);
        }
        return Math.max(noPick, pick);
    }


    public static void main(String[] args) {
         System.out.println("1====="+dp(new int []{5,6,7})) ;
        System.out.println("1=====" + dp(new int[]{1, 2, 3}));

    }


}
