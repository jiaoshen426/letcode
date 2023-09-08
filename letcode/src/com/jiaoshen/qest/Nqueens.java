package com.jiaoshen.qest;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jiaoshen
 * @date 2023-08-27-23:26
 */
public class Nqueens {
    public static int solve(int n) {
        if (n >= 20) {
            return 0;
        }
        int limit = (1 << n) - 1;
        List<List<String>> finalList = new LinkedList<>();
        int[] resultArray = new int[n];
        return process(limit, 0, 0, 0, 0, resultArray,finalList);


    }

    public static int process(int limit, int index, int colLimit, int leftLimit, int rightLimit, int[] resultArray, List<List<String>> finalList) {
        if (limit == colLimit) {
            finalList.add(print(resultArray));
            return 1;
        }

        int pos = limit & ~(colLimit | leftLimit | rightLimit);
        if (pos > 0) {
            int result = 0;
            while (pos > 0) {
                {
                    int mostRight = pos & -pos;
                    pos = pos - mostRight;
                    resultArray[index] = mostRight;
                    result += process(limit, index + 1, colLimit | mostRight, (leftLimit | mostRight) << 1, (rightLimit | mostRight) >> 1, resultArray, finalList);
                }
            }
            return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("nQueen" + solve(4));
    }

    public static List<String> print(int[] resultArray) {
        List<String> last = new LinkedList<>();
        int length = resultArray.length;
        for (int i = 0; i < length; i++) {
            int data = resultArray[i];
            String result = "";
            for (int j = 0; j < length; j++) {
                if ((data >> j & 1) > 0) {
                    result += "Q";
                } else {
                    result += ".";
                }

            }
            last.add(result);
        }
        return last;
    }

}
