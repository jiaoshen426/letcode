package com.jiaoshen.qest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>给你一个链表数组，每个链表都已经按升序排列。</p>
 *
 * <p>请你将所有链表合并到一个升序链表中，返回合并后的链表。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre><strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
 * <strong>输出：</strong>[1,1,2,3,4,4,5,6]
 * <strong>解释：</strong>链表数组如下：
 * [
 * 1-&gt;4-&gt;5,
 * 1-&gt;3-&gt;4,
 * 2-&gt;6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre><strong>输入：</strong>lists = []
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre><strong>输入：</strong>lists = [[]]
 * <strong>输出：</strong>[]
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>k == lists.length</code></li>
 * <li><code>0 &lt;= k &lt;= 10^4</code></li>
 * <li><code>0 &lt;= lists[i].length &lt;= 500</code></li>
 * <li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li>
 * <li><code>lists[i]</code> 按 <strong>升序</strong> 排列</li>
 * <li><code>lists[i].length</code> 的总和不超过 <code>10^4</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>链表</li><li>分治</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 1988</li><li>👎 0</li></div>
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    public class ListNode {
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
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            //分治
            Queue<ListNode> queue = new LinkedList<>();
            Arrays.stream(lists).forEach(queue::add);
            while (queue.size() > 1) {
                queue.add(merge(queue.poll(), queue.poll()));
            }
            return queue.peek();
        }

        /**
         * 把x和y合并到x
         *
         * @param x
         * @param y
         */
        public ListNode merge(ListNode x, ListNode y) {
            ListNode head = new ListNode();
            ListNode result = new ListNode();
            head.next = result;
            //分治
            while (x != null || y != null) {
                if (y == null && x != null) {
                    result.next = x;
                    x = x.next;


                } else if (x == null && y != null) {
                    result.next = y;
                    y = y.next;
                } else {
                    if (x.val > y.val) {
                        result.next = y;
                        y = y.next;
                    } else {
                        result.next = x;
                        x = x.next;
                    }
                }
                result = result .next;

            }
            return head.next.next;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}