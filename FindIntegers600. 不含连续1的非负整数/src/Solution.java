/**
 * @author wwx-sys
 * @time 2021-09-11-20:35
 * @description
 */
public class Solution {

    //解释一下转态转移方程： dp[i] = dp[i - 1] + dp[i - 2] ：
    //
    //dp[n]定义为从低位往高位数，前n个二进制位，所能产生的合法数字的个数。不出现连续的“1”就是合法数字。
    //
    //例如dp[2] = 3。三个合法数字分别为00，01，10。11由于有连续的1，不合法。
    //
    //给定任意一个i，i小于等于31，如何计算确定dp[i]呢？
    //
    //dp[i]中的合法数字可以从dp[i-1]和dp[i-2]中得到：
    //
    //1. 从dp[i-1]中得到：只需要在长度为i-1的合法数字的高位补充一个“0”。补充完以后的数字一定合法。
    //
    //2. 从dp[i-2]中得到：只需要在长度为i-2的合法数字的高位补充一个“10”。补充完以后的数字一定合法。
    //
    //所以dp[i]就等于dp[i-1]加上dp[i-2]。
    //
    //即dp[i] = dp[i - 1] + dp[i - 2]。 初始状态为dp[0] = dp[1] = 1。
    //
    //你可能注意到，这不就是斐波那契数列吗！没错，这就是斐波那契数列。
    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }
}
