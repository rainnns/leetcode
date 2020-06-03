class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}

/*
动态规划：
状态转移方程：dp[x]= (dp[x+1]+dp[x+2]+⋯+dp[x+W])/W
优化后dp[x]= dp[x+1]− (dp[x+W+1]−dp[x+1])/W	其中 0 <= x <= K−1。
 */