package com.jiaoshen.qest.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 *225. 用队列实现栈
 */
public class Leetcode0225 {
    Queue<Integer> queue;

    public Leetcode0225() {
        queue = new LinkedList<>();
    }




    public void push(int x) {
        queue.offer( x);
    }

    public int pop() {
        for (int i = 0; i < (queue.size() - 1); i++) {
            queue.offer(queue.poll());
        }
        return  queue.poll();
    }

    public int top() {
        for (int i = 0; i < (queue.size() - 1); i++) {
            queue.offer(queue.poll());
        }
        int result =queue.peek();
        queue.offer(queue.poll());
        return result;
    }

    public boolean empty() {
        return  queue.size() == 0;
    }

}
