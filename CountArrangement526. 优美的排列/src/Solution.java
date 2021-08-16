import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-08-16-14:45
 * @description
 */
class Solution {
    List<Integer>[] match;
    boolean[] vis;
    int num;

    public int countArrangement(int n) {
        vis = new boolean[n + 1];
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    //表示尝试向位置 index 放入数。其中 n 表示排列的长度。在当前函数中，我们首先找到一个符合条件的未被使用过的数，然后递归地执行 backtrack(index+1,n)，当该函数执行完毕，回溯到当前层，我们再尝试下一个符合条件的未被使用过的数即可。
    public void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (int x : match[index]) {
            if (!vis[x]) {
                vis[x] = true;
                backtrack(index + 1, n);
                vis[x] = false;
            }
        }
    }

    // 状态压缩 + 动态规划
    // 令 f[mask] 表示状态为 mask 时的可行方案总数，这样答案即为 f[2^n - 1]。
    // 其中 num(mask) 表示二进制数 mask 中 1 的个数，x∣y  表示 x 可以整除 y。
    // 状态转移方程的含义为，当我们想要计算 f[mask] 时，我们只需要在前 num(mask)−1 位都已经放置了数的情况下，考虑第 num(mask) 位要放置的数即可，我们枚举当前位的符合条件的数，并将方案数累加到 f[mask] 中即可。

    // 用 mask 的二进制表示选取状态，n 个数字用 n 位表示，第 i 位为 1 , 代表数字 i+1 已被选取（i从0开始），n 中 1 的个数 m 代表前 m 位已放置
    // 例如：二进制 100110 共三个1，代表排列的前三位已放置数字，三个1分别在二进制第 1、2、5位置上(从右侧开始，从0开始计数）, 所以 2、3、6三个数字被选取，综合起来就是表示：2 3 6 这三个数字被放到了排列的前三位，三个数字完美排列方式未知，通过枚举 mask 进行计算
    public int countArrangement2(int n) {
        // 用来存储中间结果，f[6] = f[000110] = 数字2、3在前两位时的完美排列数量
        int[] f = new int[1 << n];
        f[0] = 1;
        // 通过 mask 进行枚举，最终目的是为了得到二进制 mask = (11..11)n 时，总的完美排列数
        for (int mask = 1; mask < (1 << n); mask++) {
            // bitCount实现的功能是计算一个 int,long类型的数值在二进制下“1”的数量。
            int num = Integer.bitCount(mask);
            // 遍历 mask 的每一位，仍以 mask = 100110 为例，此 mask 代表 2 3 6三个数字在排列的前三位
            // 求三个数字 2 3 6 的完美排列方式，则先确定2 3 6哪些数字能放到第三位，然后累加另外两个数字的完美排列数量来获得
            // 2 3 6，第三位可以为 6，则 f[100110] += f[000110] (2、3在前两位时的完美排列数量)
            // 2 3 6，第三位可以为 3，则 f[100110] += f[100010] (2、6在前两位时的完美排列数量)
            for (int i = 0; i < n; i++) {
                // mask & (1<<i) 用来判断 mask 第 i 位是否为 1，如果为 1，说明第 i+1 个数字被选取
                // ((num % (i + 1)) == 0 || (i + 1) % num == 0) 判断被选取的数字 i+1 能否放到位置 num 上，
                // 即：先从被选取的数字中找到能放到最高位 num 的数字，然后将剩余 num-1 个数字的完美排列方式累加到f[mask]中
                if ((mask & (1 << i)) != 0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    // mask ^ (1 << i) 将 mask 第 i 位设置为 0
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[(1 << n) - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement2(4));
    }
}