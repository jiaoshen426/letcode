package com.jiaoshen.study.vo;

/**
 *
 * @author jiaoshen
 * @date 2022/8/27-15:02
 */
public class Node<T> {
    public T value;
    public Node<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node(T value) {
        this.value = value;
    }
}
