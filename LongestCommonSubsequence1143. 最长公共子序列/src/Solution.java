/**
 * @author wwx-sys
 * @time 2021-07-26-16:23
 * @description
 */
public class Solution {
    /**
     * 最长公共子序列问题是典型的二维动态规划问题。
     *
     * 假设字符串 text1 和 text2 的长度分别为 m 和 n，创建 m+1 行 n+1 列的二维数组 dp，其中 dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度。
     *
     * 当 i>0 且 j>0 时，考虑 dp[i][j] 的计算：
     *
     *     当 text1[i−1]=text2[j−1]时，将这两个相同的字符称为公共字符，考虑 text1[0:i−1] 和 text2[0:j−1] 的最长公共子序列，再增加一个字符（即公共字符）即可得到 text1[0:i] 和 text2[0:j] 的最长公共子序列，因此 dp[i][j]=dp[i−1][j−1]+1。
     *
     *     当 text1[i−1]≠text2[j−1]时，考虑以下两项：
     *
     *         text1[0:i−1] 和 text2[0:j] 的最长公共子序列；
     *
     *         text1[0:i] 和 text2[0:j−1]的最长公共子序列。
     *
     *     要得到 text1[0:i]和 text2[0:j] 的最长公共子序列，应取两项中的长度较大的一项，因此 dp[i][j]=max(dp[i−1][j],dp[i][j−1])。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
