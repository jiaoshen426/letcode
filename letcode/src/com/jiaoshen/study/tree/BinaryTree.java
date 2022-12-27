package com.jiaoshen.study.tree;

import com.jiaoshen.study.vo.TreeNode;

import java.util.Objects;

/**
 * 二叉树遍历
 *
 * @author jiaoshen
 * @date 2022-11-06-22:36
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode node = build();
        readTree(node);


    }

    public static void readTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        //先序遍历
        System.out.println(treeNode.getValue());
        readTree(treeNode.left);
        //中序遍历
        //System.out.println(treeNode.getValue());
        readTree(treeNode.right);
        //后序遍历
        //System.out.println(treeNode.getValue());
    }

    /**
     * 构建二叉树
     *
     * @return
     */
    public static TreeNode build() {
        //          a
//         b    c
//       d  e f   g
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        return a;
    }


}
