/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/1 17:25
 */
public class Solution {

    /**
     * DP 优化版 定义动态规划的状态 dp[i][j] 为经过 i 轮传递到编号 j 的玩家的方案数，其中 0≤i≤k , 0≤j<n。
     *
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n - 1];
    }

    //DP
    public int numWays2(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i + 1][dst] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }



    public static void main(String[] args) {
        int n = 5;
        int[][] relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        System.out.println(new Solution().numWays(n, relation, k));
    }
}
