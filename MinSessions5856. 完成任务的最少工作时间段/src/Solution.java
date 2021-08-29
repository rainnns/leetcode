import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/29 11:27
 */
public class Solution {
    //思路
    //1 <= n <= 14，大家以后看到这个数据范围就要条件反射的想到要状压~
    //（以普遍理性而论，状压的数据范围都会小于 20）
    //那么，得到最优解的充要条件是什么？
    //首先，所有任务都需要做完；其次，尽可能将任务紧凑的安排在一起，花费尽可能少的时间段去完成。

    //状态压缩
    //
    //我们可以将每个任务 task[i] 看作二进制上的一位，1 表示选择该任务，反之为不选。
    //
    //完成所有任务的状态则为：(1 << n) - 1 ，即二进制为 n 个 1。

    //Q：最小的花费怎么得到（Base Case）？
    //A：暴力地枚举每一个状态，计算当前状态选择的任务总耗时，如果没有超过 sessionTime，则代表该状态可以在 1 个时间段内完成。
    //
    //Q：剩下的状态怎么得到最优解？
    //A：这时可以引入一个小技巧，枚举 「 二进制子集 」 ，枚举子集的时候可借机完成状态转移。
    //
    //举个例子：[1, 2, 3]，任务全部完成时的状态为：111，而 111 的子集有：
    //111 110 101 100
    //11 10
    //1
    //随便拿出一个状态，比如 110，它可以与它的补集 1 共同组成 111，如果这两个子集的时间段消耗更少，我们就拿来更新 111 这个状态的消耗。

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length, m = 1 << n;
        final int INF = 20;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);

        // 预处理每个状态，合法状态预设为 1
        for (int i = 1; i < m; i++) {
            int state = i, idx = 0;
            int spend = 0;
            while (state > 0) {
                int bit = state & 1;
                if (bit == 1) {
                    spend += tasks[idx];
                }
                state >>= 1;
                idx++;
            }
            if (spend <= sessionTime) {
                dp[i] = 1;
            }
        }

        // 对每个状态枚举子集，跳过已经有最优解的状态
        for (int i = 1; i < m; i++) {
            if (dp[i] != INF) {
                continue;
            }
            for (int j = i; j > 0; j = (j - 1) & i) {
                // i 状态的最优解可能由当前子集 j 与子集 j 的补集得来
                dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
            }
        }

        return dp[m - 1];
    }



    public int minSessions1(int[] tasks, int sessionTime) {
        int len = tasks.length;
        int size = 1 << len;
        int[] dp = new int[size];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if ((j & i) == i) {
                    int t = j ^ i;
                    int cur = 0;
                    for (int k = 0; k < len; k++) {
                        if (((t >> k )& 1) == 1){
                            cur += tasks[k];
                        }
                    }
                    if (cur <= sessionTime) {
                        dp[j] = Math.min(dp[j],dp[i] + 1);
                    }
                }
            }
        }
        return dp[(1 << len) - 1];
    }

    public static void main(String[] args) {
        int[] tasks = new int[]{1,5,7,10,3,8,4,2,6,2};
        System.out.println(new Solution().minSessions(tasks, 10));
    }
}
