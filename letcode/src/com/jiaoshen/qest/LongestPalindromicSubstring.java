package com.jiaoshen.qest;

import java.util.Arrays;

/**
 * <p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>
 *
 * <p>如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "babad"
 * <strong>输出：</strong>"bab"
 * <strong>解释：</strong>"aba" 同样是符合题意的答案。
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "cbbd"
 * <strong>输出：</strong>"bb"
 * </pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= s.length &lt;= 1000</code></li>
 * <li><code>s</code> 仅由数字和英文字母组成</li>
 * </ul>
 * <div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 6722</li><li>👎 0</li></div>
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] str = s.toCharArray();
            if(s== null){
                return null;
            }
            int length = str.length;
            if (s.length() < 2) {
                return s;
            }

            int[][] dp = new int[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = 1;
            }
            int maxLength = 1;
            String maxStr = s.substring(0, 1);
            //dp[i][j] = dp[i+1][j-1] && (j-i<3 || s[j] == s[i] )
            for (int j = 0; j < length; j++) {
                for (int i = 0; i < length && j > i; i++) {
                    if (j - i == 1 && str[i] == str[j]) {
                        dp[i][j] = 1;
                        if ((j - i + 1) > maxLength) {
                            maxStr = s.substring(i, j + 1);
                            maxLength = (j - i + 1);
                        }
                    }
                    if (j - i >= 2 && (dp[i + 1][j - 1] > 0 && str[i] == str[j])) {
                        dp[i][j] = 1;
                        if ((j - i + 1) > maxLength) {
                            maxStr = s.substring(i, j + 1);
                            maxLength = (j - i + 1);
                        }
                    }
                }
            }
            for (int j = 0; j < length; j++) {
                System.out.println(Arrays.toString(dp[j]));
            }

            return maxStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}