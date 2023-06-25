package com.jiaoshen.study.dynamic;

/**
 * @author jiaoshen
 * @date 2023-06-23-10:39
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线
 * 玩家A和玩家B依次拿走每张纸牌
 * 规定玩家A先拿，玩家B后拿
 * 但是每个玩家每次只能拿走最左或最右的纸牌
 * 玩家A和玩家B都绝顶聪明
 * 请返回最后获胜者的分数
 * Todo 模仿DynamicTest1
 */

public class DynamicTest2 {


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        System.out.println(way1(2, 6, 4, 5));
        System.out.println(way2(2, 6, 4, 5));
        System.out.println(way3(2, 6, 4, 5));

    }

    /**
     * 暴力递归
     */
    /**
     * @param N       总长度
     * @param cur     现在格的index
     * @param wAmount 必须走多少步
     * @param target  目标格的index
     * @return
     */
    public static int way1(int cur, int wAmount, int target, int N) {
        if (wAmount == 0) {
            if (cur == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (cur == 1) {
            return way1(cur + 1, wAmount - 1, target, N);
        }
        if (cur == N) {
            return way1(cur - 1, wAmount - 1, target, N);
        } else {
            return way1(cur + 1, wAmount - 1, target, N) + way1(cur - 1, wAmount - 1, target, N);
        }

    }

    /**
     * @param cur
     * @param wAmount
     * @param target
     * @param N
     * @return
     */
    public static int way2(int cur, int wAmount, int target, int N) {
        int[][] cacheResult = new int[N + 1][wAmount + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < wAmount + 1; j++) {
                cacheResult[i][j] = -1;
            }
        }
        return process2(cur, wAmount, target, N, cacheResult);
    }

    public static int process2(int cur, int wAmount, int target, int N, int[][] cacheResult) {
        if (cacheResult[cur][wAmount] != -1) {
            return cacheResult[cur][wAmount];
        }
        if (wAmount == 0) {
            if (cur == target) {
                cacheResult[cur][wAmount] = 1;
                return 1;
            } else {
                cacheResult[cur][wAmount] = 0;
                return 0;
            }
        }
        if (cur == 1) {
            return way1(cur + 1, wAmount - 1, target, N);
        }
        if (cur == N) {
            return way1(cur - 1, wAmount - 1, target, N);
        } else {
            return way1(cur + 1, wAmount - 1, target, N) + way1(cur - 1, wAmount - 1, target, N);
        }
    }

    public static int way3(int cur, int wAmount, int target, int N) {
        int[][] cacheResult = new int[N + 1][wAmount + 1];
        cacheResult[target][0] = 1;
        for (int rest = 1; rest <= wAmount; rest++) {
            cacheResult[1][rest] = cacheResult[2][rest - 1];
            for (int cur1 = 2; cur1 <= N - 1; cur1++) {
                cacheResult[cur1][rest] = cacheResult[cur1 - 1][rest - 1] + cacheResult[cur1 + 1][rest - 1];
            }
            cacheResult[N][rest] = cacheResult[N - 1][rest - 1];
        }
        return cacheResult[cur][wAmount];

    }


}
