package com.jiaoshen.study.tree;


import com.jiaoshen.study.vo.TreeNode;

/**
 * 判断一课树是否搜索二叉树
 * 搜索二叉树：左子树节点都比根节点小，右子树节点都比根节点大
 *
 * @author jiaoshen
 * @date 2022-12-30-15:09
 */
public class JudgeSearchTree {
    public static class Info {
        public Integer max;
        public Integer min;
        boolean isS;

        public Info(Integer max, Integer min, boolean isS) {
            this.max = max;
            this.min = min;
            this.isS = isS;

        }
    }

    public static boolean judgeST(TreeNode<Integer> head) {
        return false;
    }

    public static Info process(TreeNode<Integer> head) {
        if (head == null) {
            return null;
        }
        boolean isS = true;
        Integer max = head.value;
        Integer min = head.value;
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        if (leftInfo != null) {
            max = Math.max(max, leftInfo.max);
            min = Math.min(min, leftInfo.min);
            if (leftInfo.max > head.value || !leftInfo.isS) {
                isS = false;
            }
        }
        if (rightInfo != null) {
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            if (rightInfo.min < head.value || !rightInfo.isS) {
                isS = false;
            }
        }
        return new Info(max, min, isS);

    }


}
