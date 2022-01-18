package com.jiaoshen.qest.linkedlist;

public class Leetcode0203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode indexNode = head;
        ListNode result = head;
        while (indexNode != null) {
            if (result.val == val ) {
                result = result.next;
            }
            else  {
                while (indexNode.next != null && indexNode.next.val == val){
                    indexNode.next = indexNode.next.next;
                }
            }
            indexNode = indexNode.next;
            System.out.println(result);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        ListNode head = new ListNode(a[0]);
        ListNode temp = head;
        for (int i = 1; i < a.length; i++) {
            temp.next = new ListNode(a[i]);
            temp = temp.next;
        }
        System.out.println(head);
        System.out.println(removeElements(head, 2));

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode temp = this;
            StringBuffer result = new StringBuffer();
            while (temp != null) {
                result.append(temp.val + ",");
                temp = temp.next;
            }
            return result.toString();
        }
    }
}
