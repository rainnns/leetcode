/**
 * @author wwx-sys
 * @time 2021-09-04-8:42
 * @description
 */
public class Solution {
    int mod = 1000000007;
    int n_2 = 0;
    int n_1 = 1;

    public int fib(int n) {
        int f = 0;
        if (n == 1){return 1;}
        for (int i = 2; i <= n; i++) {
            f = (n_2 + n_1) % mod;
            n_2 = n_1;
            n_1 = f;
        }
        return f;
    }
}
