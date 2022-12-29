package com.jiaoshen.study.tree;

import com.jiaoshen.study.vo.TreeNode;

import java.util.*;

/**
 * 二叉树遍历
 *
 * @author jiaoshen
 * @date 2022-11-06-22:36
 */
public class BinaryTree {
    public static void main(String[] args) {
        TreeNode head = build();
        //readTree2(node);

      System.out.println("weight="+getMaxWeight(head));


    }

    /**
     * 递归实现二叉树遍历
     * 先序遍历 头左右 abdecfg
     * 后序遍历 左右头 debfgca
     * 中序遍历 左头右 dbeafcg
     *
     * @param treeNode
     */
    public static void readTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return;
        }
        //先序遍历
        //System.out.print(treeNode.getValue());
        readTree(treeNode.left);
        //中序遍历
        System.out.print(treeNode.getValue());
        readTree(treeNode.right);
        //后序遍历
        //System.out.print(treeNode.getValue());
    }

    /**
     * 非递归实现二叉树遍历
     * 用栈
     *
     * @param treeNode
     */
    public static void readTree2(TreeNode treeNode) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(treeNode);
        List<TreeNode> result = new ArrayList<>();
        while (deque.size() > 0) {
            TreeNode popNode = deque.pop();
            result.add(popNode);
            if (popNode.right != null) {
                deque.push(popNode.right);
            }
            if (popNode.left != null) {
                deque.push(popNode.left);
            }
        }
        result.stream().map(TreeNode::getValue).forEach(System.out::print);
    }

    /**
     * 序列化
     *
     * @param treeNode
     */
    public static void serializeTree(TreeNode treeNode) {
        //TODO
    }

    /**
     * 求二叉树最大宽度层并且返回
     *
     * @param treeNode
     */
    public static Integer getMaxWeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode curEnd = treeNode;
        TreeNode nextEnd = null;
        Integer curNums = 0;
        Integer maxNums = 0;
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            curNums++;
            if (cur.left != null) {
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur.equals(curEnd)) {
                maxNums = Math.max(maxNums, curNums);
                curEnd = nextEnd;
                curNums = 0;
            }
        }
        return maxNums;
    }


    /**
     * 构建二叉树
     *
     * @return
     */
    public static TreeNode build() {
        //    a
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

    /**
     * 构建二叉树
     *
     * @return
     */
    public static TreeNode build2() {
//            a
//         b    c
//           e  f   g
//            d   h
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        TreeNode h = new TreeNode("h");

        a.left = b;
        a.right = c;
        b.right = e;
        c.left = f;
        c.right = g;
        f.left = d;
        f.right = h;
        return a;
    }


}
