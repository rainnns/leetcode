/**
 * @author wwx-sys
 * @time 2021-08-13-15:42
 * @description
 */
public class Solution {
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

    public int countDigitOne2(int n) {
        String s = String.valueOf(n);
        int m = s.length();
        if (m == 1) return n > 0 ? 1 : 0;
        // 计算第 i 位前缀代表的数值，和后缀代表的数值
        // 例如 abcde 则有 ps[2] = ab; ss[2] = de
        int[] ps = new int[m], ss = new int[m];
        ss[0] = Integer.parseInt(s.substring(1));
        for (int i = 1; i < m - 1; i++) {
            ps[i] = Integer.parseInt(s.substring(0, i));
            ss[i] = Integer.parseInt(s.substring(i + 1));
        }
        ps[m - 1] = Integer.parseInt(s.substring(0, m - 1));
        // 分情况讨论
        int ans = 0;
        for (int i = 0; i < m; i++) {
            // x 为当前位数值，len 为当前位后面长度为多少
            int x = s.charAt(i) - '0', len = m - i - 1;
            int prefix = ps[i], suffix = ss[i];
            int tot = 0;
            tot += prefix * Math.pow(10, len);
            if (x == 0) {
            } else if (x == 1) {
                tot += suffix + 1;
            } else {
                tot += Math.pow(10, len);
            }
            ans += tot;
        }
        return ans;
    }


    //超时
    public int countDigitOne1(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int t = i;
            while (t != 0) {
                int mod = t % 10;
                if (mod == 1) {
                    count++;
                }
                t = t / 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(13));
    }
}
