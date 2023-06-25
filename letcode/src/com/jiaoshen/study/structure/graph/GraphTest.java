package com.jiaoshen.study.structure.graph;

import com.jiaoshen.study.structure.graph.vo.Node;

import java.util.*;

/**
 * @author jiaoshen
 * @date 2023-01-31-22:34
 */
public class GraphTest {
    /**
     * 深度遍历
     *
     * @param head
     */
    public static void dfs(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Node> set = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        set.add(head);
        System.out.println(head.value);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            for (Node next : temp.nexts) {
                if (!set.contains(next)) {
                    System.out.println(next.value);
                    stack.push(temp);
                    stack.push(next);
                    set.add(next);
                    break;
                }
            }
        }


    }

    /**
     * 宽度遍历
     * 队列  出队列的时候 进其子节点 用set 排重
     *
     * @param head
     */
    public static void bfs(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        set.add(head);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.value);
            for (Node next : temp.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }


}
