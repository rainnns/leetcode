/**
 * @author wwx-sys
 * @time 2021-10-02-11:46
 * @description 剑指 Offer 16. 数值的整数次方
 */

public class T16 {
    //快速幂法
    //Java 代码中 int32 变量 n∈[−2147483648,2147483647]n \in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，因此当 n=−2147483648 时执行 n=−n 会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1;
        double c = x;
        long b = n;
        if (b < 0) {
            c = 1 / c;
            b = -b;
        }
        for (long i = b; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                res *= c;
            }
            c *= c;
        }
        return res;
    }

}
