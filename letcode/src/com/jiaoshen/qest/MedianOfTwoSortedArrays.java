package com.jiaoshen.qest;

/**
 * <p>给定两个大小分别为 <code>m</code> 和 <code>n</code> 的正序（从小到大）数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。请你找出并返回这两个正序数组的 <strong>中位数</strong> 。</p>
 *
 * <p>算法的时间复杂度应该为 <code>O(log (m+n))</code> 。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,3], nums2 = [2]
 * <strong>输出：</strong>2.00000
 * <strong>解释：</strong>合并数组 = [1,2,3] ，中位数 2
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums1 = [1,2], nums2 = [3,4]
 * <strong>输出：</strong>2.50000
 * <strong>解释：</strong>合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>nums1.length == m</code></li>
 * <li><code>nums2.length == n</code></li>
 * <li><code>0 &lt;= m &lt;= 1000</code></li>
 * <li><code>0 &lt;= n &lt;= 1000</code></li>
 * <li><code>1 &lt;= m + n &lt;= 2000</code></li>
 * <li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li><li>分治</li></div></div><br><div><li>👍 7203</li><li>👎 0</li></div>
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        new MedianOfTwoSortedArrays().new Solution().findMedianSortedArrays(new int[]{3}, new int[]{-2, -1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length == 0 && nums2.length == 0){
                return 0;
            }
            if(nums1.length == 0){
                return ((double) nums2[((nums2.length - 1)/2)]+(double)nums2[(nums2.length/2)] )/ 2;
            }
            if(nums2.length == 0){
                return ((double) nums1[((nums1.length - 1)/2)]+(double)nums1[(nums1.length /2)] )/ 2;
            }
            int max1 = nums1.length - 1;
            int max2 = nums2.length - 1;
            int min1 = 0;
            int min2 = 0;
            boolean array1over;
            boolean array2over;

            //总移动次数
            int total = (max1 + max2) / 2+1;
            for (int i = 0; i < total; i++) {





                if (nums1[min1] < nums2[min2] ) {
                    min1++;
                } else {
                    min2++;
                }
                if (nums1[max1] < nums2[max2]) {
                    max2--;
                } else {
                    max1--;
                }
                if(min1 == max1){
                    array1over =true;
                }
                if(min2 == max2){
                    array2over =true;
                }
            }
            int resultMin = Math.min(nums1[min1], nums2[min2]);
            int resultMax = Math.max(nums1[max1], nums2[max2]);
            double result = ((double) resultMin + (double) resultMax) / 2;
            System.out.println("result" + result);
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}