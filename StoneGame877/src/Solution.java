/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/16 20:44
 */
public class Solution {

    //动态规划
    //定义二维数组dp,其行数和列数都等于石子的堆数，dp[i][i] 表示当剩下的石子堆为下标i到下标j时，当前玩家与另一个玩家的石子数量之差的最大值,注意当前玩家不-定是先手Alex。
    //只有当i<j时,剩下的石子堆才有意义，因此当i>j时，dp[i][i]= 0.
    //当i=j时，只剩下一堆石子，当前玩家只能取走这堆石子，因此对于所有0≤i < nums.length,都有dp[i][i] = piles[i]。
    //当i<j时，当前玩家可以选择取走piles[i] 或piles[j]，然后轮到另一个玩家在剩下的石子堆中取走石子。 在两种方案中，当前玩家会选择最优的方案，使得自己的石子数量最大化。因此可以得到如下状态转移方程:
    //dp[i][j] = max(piles[i] - dp[i + 1,j], piles[j] - dp[i,j-1])
    //最后判断dp[0][piles.length- 1] 的值，如果大于0，则Alex的石子数量大于Lee的石子数量，因此Alex赢得比赛，否则Lee赢得比赛。
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }

    //数学
    public boolean stoneGame2(int[] piles) {
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.stoneGame(new int[]{5, 3, 4, 5}));
    }
}
