package com.jiaoshen.study.sort.merge;

/**
 * <p>给你一个整数数组 <code>nums</code> 以及两个整数 <code>lower</code> 和 <code>upper</code> 。求数组中，值位于范围 <code>[lower, upper]</code> （包含 <code>lower</code> 和 <code>upper</code>）之内的 <strong>区间和的个数</strong> 。</p>
 *
 * <p><strong>区间和</strong> <code>S(i, j)</code> 表示在 <code>nums</code> 中，位置从 <code>i</code> 到 <code>j</code> 的元素之和，包含 <code>i</code> 和 <code>j</code> (<code>i</code> ≤ <code>j</code>)。</p>
 *
 * <p> </p>
 * <strong>示例 1：</strong>
 *
 * <pre>
 * <strong>输入：</strong>nums = [-2,5,-1], lower = -2, upper = 2
 * <strong>输出：</strong>3
 * <strong>解释：</strong>存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [0], lower = 0, upper = 0
 * <strong>输出：</strong>1
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
 * <li><code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code></li>
 * <li><code>-10<sup>5</sup> <= lower <= upper <= 10<sup>5</sup></code></li>
 * <li>题目数据保证答案是一个 <strong>32 位</strong> 的整数</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>树状数组</li><li>线段树</li><li>数组</li><li>二分查找</li><li>分治</li><li>有序集合</li><li>归并排序</li></div></div><br><div><li>👍 433</li><li>👎 0</li></div>
 */
public class CountOfRangeSum {
    public static void main(String[] args) {
        Solution solution = new CountOfRangeSum().new Solution();
        int[] nums = {-2,5,-1};
        int lower=-2;
        int upper = 2;
       System.out.println(solution.countRangeSum(nums,lower,upper)) ;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int[] preSum = new int[nums.length];
            //求前缀和
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                preSum[i] = sum;
            }
            return process(preSum, 0, nums.length - 1, lower, upper);
        }

    }

    private int process(int sum[], int left, int right, int lower, int upper) {
        if (left > right) {
            return 0;
        } else if (left == right) {
            if (sum[left] >= lower && sum[left] <= upper) {
                System.out.println("left:" + left + ";right:" + right);
                return 1;
            } else {
                return 0;
            }
        }
        int mid = (right + left) >> 1;
        return process(sum, left, mid, lower, upper) + process(sum, mid + 1, right, lower, upper) + merge(sum, left, right, mid, lower, upper);
    }

    /**
     * 左小值累加之和
     *
     * @param sum
     * @param left
     * @param right
     * @param mid
     * @return
     */
    private int merge(int sum[], int left, int right, int mid, int lower, int upper) {
        int[] temp = new int[right - left + 1];
        //临时数组下标
        int indexLeft = left;
        int indexRight = mid + 1;
        int result = 0;
        for (int i = mid + 1; i <= right; i++) {
            int min = sum[i] - upper;
            int max = sum[i] - lower;
            for (int j = left; j <= mid; j++) {
                if (sum[j] >= min && sum[j] <= max) {
                    System.out.println("left:" + (j - 1) + ";right:" + i);
                    result++;
                }
            }
        }
        int i = 0;
        while (indexLeft <= mid || indexRight <= right) {
            if (indexLeft > mid) {
                temp[i++] = sum[indexRight++];
            } else if (indexRight > right) {
                temp[i++] = sum[indexLeft++];
            } else {
                if (sum[indexLeft] < sum[indexRight]) {
                    temp[i++] = sum[indexLeft++];
                } else {
                    temp[i++] = sum[indexRight++];
                }
            }
        }
        for (int j = 0; j <= right - left; j++) {
            sum[j + left] = temp[j];
        }
        return result;
    }


//leetcode submit region end(Prohibit modification and deletion)

  }