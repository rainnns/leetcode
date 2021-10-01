/**
 * @author wwx-sys
 * @time 2021-10-01-12:09
 * @description 剑指 Offer 14- II. 剪绳子 II
 */
public class T14_2 {
    //Math.pow(3, a)可能会超出Int范围，这里需要解决大数求余
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, mod = 1000000007;
        long rem = 1, c = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) rem = (rem * c) % mod;
            c = (c * c) % mod;
        }
        if (b == 0) return (int) (rem * 3 % mod);
        if (b == 1) return (int) (rem * 4 % mod);
        return (int) (rem * 6 % mod);
    }

    //循环求余
    public int circleMod(int c, int n, int mod) {
        int res = 1;
        while (n != 0) {
            res *= c % mod;
            n--;
        }
        return res;
    }

}
