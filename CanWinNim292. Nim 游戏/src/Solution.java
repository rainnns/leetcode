import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-09-18-17:29
 * @description
 */
public class Solution {
    public boolean canWinNim1(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = dp[2] = dp[3] = true;

        for (int i = 4; i <= n; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 2] && dp[i - 3]);

        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canWinNim(10));
    }
}
