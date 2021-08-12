/**
 * @author wwx-sys
 * @time 2021-08-12-15:46
 * @description
 */
public class Solution {

    //动态规划
    // 用 dp[i][j] 表示字符串 s 的下标范围 [i, j] 内的最长回文子序列的长度。
    //当 i < j 时，计算 dp[i][j] 需要分别考虑 s[i] 和 s[j] 相等和不相等的情况：
    //
    //    如果 s[i] = s[j]，则首先得到 s 的下标范围 [i+1, j-1]内的最长回文子序列，然后在该子序列的首尾分别添加 s[i] 和 s[j]，即可得到 s 的下标范围 [i, j] 内的最长回文子序列，因此 dp[i][j]= dp[i+1][j−1] + 2；
    //
    //    如果 s[i]≠s[j]，则 s[i] 和 s[j] 不可能同时作为同一个回文子序列的首尾，因此 dp[i][j]=max(dp[i+1][j],dp[i][j−1])。
    //
    //由于状态转移方程都是从长度较短的子序列向长度较长的子序列转移，因此需要注意动态规划的循环顺序。
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindromeSubseq("bbbab"));
    }
}
