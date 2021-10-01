/**
 * @author wwx-sys
 * @time 2021-09-30-18:21
 * @description 剑指 Offer 14- I. 剪绳子
 */
public class T14 {
    //数学推导下，切为多段长度为3绳子乘积最大
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int num = n / 3, mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, num);
        } else if (mod == 1) {
            return (int) (Math.pow(3, num - 1) * 4);
        }
        return (int) (Math.pow(3, num) * 2);
    }

    //动态规划
    //我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
    //用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，初始化dp[2] = 1
    //我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
    //剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
    //第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
    //dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
    //最后返回dp[n]即可
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(new T14().cuttingRope(12));
    }
}
