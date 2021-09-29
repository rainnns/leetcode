/**
 * @author wwx-sys
 * @time 2021-09-29-11:12
 * @description 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class T10 {

    public int numWays(int n) {
        int mod = 1000000007;
        int a = 1, b = 1;
        int res = a;
        for (int i = 2; i <= n; i++) {
            res = (a + b) % mod;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T10().numWays(7));
    }
}
