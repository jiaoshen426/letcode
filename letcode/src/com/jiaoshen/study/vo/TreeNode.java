package com.jiaoshen.study.vo;

/**
 *
 * @author jiaoshen
 * @date 2022/8/27-15:02
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;

    public TreeNode<T> right;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode(T value) {
        this.value = value;
    }
}
