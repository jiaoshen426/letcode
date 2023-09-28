package com.jiaoshen.test;

/**
 * @author jiaoshen
 * @date 2023/9/12-9:07
 */
public class Test3 {
    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() {
        final Test3 test = new Test3(); // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return test.count;
    }

    public static void main(String[] args) {
        System.out.println("======"+calc());

    }
}