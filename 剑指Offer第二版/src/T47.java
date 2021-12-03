/**
 * @author wwx-sys
 * @time 2021-12-03-14:49
 * @description 剑指 Offer 47. 礼物的最大价值
 */
public class T47 {
    int m, n;
    public int maxValue(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
