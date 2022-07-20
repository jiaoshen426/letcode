package com.jiaoshen.study.tree;

import org.w3c.dom.Node;

/**
 * 前缀树
 * 主要为了统计和检索
 *
 * @author jiaoshen
 * @date 2022/7/10-0:45
 */
public class TrieTree {
    public static class Node {
        public int pass;
        public int end;
        public Node[] nexts;

        // char tmp = 'b'  (tmp - 'a')
        public Node() {
            pass = 0;
            end = 0;
            // 0    a
            // 1    b
            // 2    c
            // ..   ..
            // 25   z
            // nexts[i] == null   i方向的路不存在
            // nexts[i] != null   i方向的路存在
            nexts = new Node[26];
        }

        public static class Tree {
            public Node root;

            public Tree() {
                root = new Node();
            }

            public void insert(String word) {
                if (word == null) {
                    return;
                }
                Node node = root;
                node.pass++;
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {

                    int index = wordArray[i] - 'a';
                    if (node.nexts[index] == null) {
                        node.nexts[index] = new Node();
                    }
                    node.nexts[index].pass++;
                    node = node.nexts[index];
                    if (i == wordArray.length - 1) {
                        node.end++;
                    }
                }


            }

            public void delete(String word) {
                if (word == null) {
                    return;
                }
                Node node = root;
                node.pass++;
                char[] wordArray = word.toCharArray();
                for (int i = 0; i < wordArray.length; i++) {
                    int index = wordArray[i] - 'a';
                    if (node.nexts[index] == null) {
                        return;
                    }
                    node.nexts[index].pass--;
                    node = node.nexts[index];
                    if (i == wordArray.length - 1) {
                        node.end--;
                    }
                }
            }

            public int search(String word) {
                Node node = root;
                char[] wordArray = word.toCharArray();
                int result = 0;
                for (int i = 0; i < wordArray.length; i++) {
                    int index = wordArray[i] - 'a';
                    if (node.nexts[index] == null) {
                        return 0;
                    }
                    node = node.nexts[index];
                    result = node.end;
                }
                return result;
            }

            public int prefixNumber(String word) {
                Node node = root;
                char[] wordArray = word.toCharArray();
                int result = 0;
                for (int i = 0; i < wordArray.length; i++) {
                    int index = wordArray[i] - 'a';
                    if (node.nexts[index] == null) {
                        return 0;
                    }
                    node = node.nexts[index];
                    result = node.pass;
                }
                return result;
            }


        }

        // for test
        public static String generateRandomString(int strLen) {
            char[] ans = new char[(int) (Math.random() * strLen) + 1];
            for (int i = 0; i < ans.length; i++) {
                int value = (int) (Math.random() * 6);
                ans[i] = (char) (97 + value);
            }
            return String.valueOf(ans);
        }

        // for test
        public static String[] generateRandomStringArray(int arrLen, int strLen) {
            String[] ans = new String[(int) (Math.random() * arrLen) + 1];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = generateRandomString(strLen);
            }
            return ans;
        }

        public static void main(String[] args) {
            int arrLen = 100;
            int strLen = 20;
            int testTimes = 100000;
            for (int i = 0; i < testTimes; i++) {
                String[] arr = generateRandomStringArray(arrLen, strLen);
                Tree trie1 = new Tree();
                for (int j = 0; j < arr.length; j++) {
                    double decide = Math.random();
                    if (decide < 0.25) {
                        trie1.insert(arr[j]);
                    } else if (decide < 0.5) {
                        trie1.delete(arr[j]);
                    } else if (decide < 0.75) {
                        int ans1 = trie1.search(arr[j]);
                        System.out.println("ans1="+ans1);
                    } else {
                        int ans1 = trie1.prefixNumber(arr[j]);
                        System.out.println("ans2="+ans1);
                    }
                }
            }
            System.out.println("finish!");

        }


    }


}
