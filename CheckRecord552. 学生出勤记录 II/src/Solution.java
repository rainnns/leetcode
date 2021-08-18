import java.util.Arrays;
import java.util.stream.LongStream;

/**
 * @author wwx-sys
 * @time 2021-08-18-14:38
 * @description
 */
public class Solution {

    //1、DFS +   记忆化
    int MOD = 1000000007;

    public int checkRecord1(int n) {
        int[][][] memo = new int[n][2][3];
        return dfs(0, n, 0, 0, memo);
    }

    private int dfs(int day, int n, int absent, int late, int[][][] memo) {
        if (day >= n) {
            return 1;
        }

        // 相同的状态计算过了直接返回
        if (memo[day][absent][late] != 0) {
            return memo[day][absent][late];
        }

        // 回溯开始
        int ans = 0;
        // 1. Present随便放
        ans = (ans + dfs(day + 1, n, absent, 0, memo)) % MOD;
        // 2. Absent最多只能放一个
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0, memo)) % MOD;
        }
        // 3. Late最多连续放2个
        if (late < 2) {
            ans = (ans + dfs(day + 1, n, absent, late + 1, memo)) % MOD;
        }

        // 记录每一个状态的计算结果
        memo[day][absent][late] = ans;

        return ans;
    }


    //2、动态规划
    //定义 dp[i][j][k]表示第 i 天、在 A 为 j 次、连续的 L 为 k 次的方案数，其中 0≤i≤n, 0=< j =< 1 , 0≤k≤2。
    //当前填入的是 P，i-1 天的任何状态都能转移过来；
    //当前填入的是 A，i-1 天即之前肯定没填过 A，同时所有的 late 状态都可以转移到过来。
    //当前填入的是 L，i-1 天最多只能有一个连续的 L，其他的状态依次转移过来。

    public int checkRecord2(int n) {
        long[][][] dp = new long[n][2][3];
        // 初始值
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[0][0][1] = 1;

        for (int i = 1; i < n; i++) {
            // 本次填入P，分成前一天累计了0个A和1个A两种情况
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;
            // 本次填入A，前一天没有累计A都能转移过来
            // 这行可以与上面一行合并计算，为了方便理解，我们分开，下面会合并
            dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            // 本次填入L，前一天最多只有一个连续的L，分成四种情况
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }

        // 计算结果，即最后一天的所有状态相加
        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }

        return (int) ans;
    }

    //3、动态规划 + 降维I
    //在方法2中，可以看到，i 天的状态只与 i-1 天的状态有关，所以，i-1 天之前的状态完全不需要存储，我们这里可以使用临时数组优化一下。
    //
    //注意：不能直接在原 dp 数组上计算，因为 i-1 天的状态会被多次利用，直接覆盖会导致结果不准确。
     public int checkRecord3(int n) {
        long[][] dp = new long[2][3];
        // 初始值
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            long[][] newDp = new long[2][3];
            newDp[0][0] = (dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            // 把方法三中间两个一样的状态合并为一行
            newDp[1][0] = (dp[1][0] + dp[1][1] + dp[1][2] + dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            newDp[0][1] = dp[0][0];
            newDp[0][2] = dp[0][1];
            newDp[1][1] = dp[1][0];
            newDp[1][2] = dp[1][1];

            dp = newDp;
        }

        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[i][j]) % MOD;
            }
        }

        return (int) ans;
    }

    //4、动态规划 + 降维II
    //通过前面的分析，我们可以看到，其实一共就只有 6 种状态，所以，我们可以只声明一个一维数组代替上面的二维数组，将二维降维成一维。
    //
    //二维降一维的计算公式为：index=i∗n+j，大家要记住，直接在方法3的基础改两下代码就成了。
    public int checkRecord4(int n) {
        long[] dp = new long[6];
        // 初始值
        dp[0] = 1;
        dp[1] = 1;
        dp[3] = 1;

        for (int i = 1; i < n; i++) {
            long[] newDp = new long[6];
            newDp[0] = (dp[0] + dp[1] + dp[2]) % MOD;
            newDp[1] = dp[0];
            newDp[2] = dp[1];
            // 稍微调整了一下顺序
            newDp[3] = (dp[3] + dp[4] + dp[5] + dp[0] + dp[1] + dp[2]) % MOD;
            newDp[4] = dp[3];
            newDp[5] = dp[4];

            dp = newDp;
        }

        return (int) (LongStream.of(dp).sum() % MOD);
    }

    // 5、 矩阵快速幂
    //将4中的递推关系转换为矩阵的运算
    //时间复杂度：O(log(n))。
    //空间复杂度：O(1)。

     public int checkRecord5(int n) {
        long[][] mat = {{1, 1, 0, 1, 0, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1, 0},
                        {0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0}};
        long[][] res = pow(mat, n);
        long sum = Arrays.stream(res[0]).sum();
        return (int) (sum % MOD);
    }

    public long[][] pow(long[][] mat, int n) {
        long[][] ret = {{1, 0, 0, 0, 0, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, mat);
            }
            n >>= 1;
            mat = multiply(mat, mat);
        }
        return ret;
    }

    public long[][] multiply(long[][] a, long[][] b) {
        int rows = a.length, columns = b[0].length, temp = b.length;
        long[][] c = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = 0; k < temp; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    c[i][j] %= MOD;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord2(10101));
    }
}
