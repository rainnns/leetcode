import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/22 15:38
 */
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型 未来空闲工作日
     * @return int整型
     */
    public int workSchedule(int n) {
        // write code here
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;


        return dp[n];


    }


    public int fn(int a1, int n, int d) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += a1 + i * (d + i % 3);
        }
        return sum;
    }

    //完全数
    public void perfectNum() {
        for (int i = 2; i <= 33; i++) {
            long t = (1L << i) - 1;
            if (isZhiShu(t)) {
                long perfectNum = (1L << (i - 1)) * t;
                System.out.println(perfectNum);
            }
        }
    }

    public boolean isZhiShu(long n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution2().perfectNum();
    }
}
