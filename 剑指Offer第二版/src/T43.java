/**
 * @author wwx-sys
 * @time 2021-11-08-15:55
 * @description 剑指 Offer 43. 1～n 整数中 1 出现的次数
 */
public class T43 {
    public int countDigitOne(int n) {
        int num = n;
        int cur, high, low;
        int digit = 1;
        int res = 0;
        while (num != 0) {
            cur = num % 10;
            high = num / 10;
            low = n % digit;
            int count;
            if (cur == 0) {
                count = high * digit;
            } else if (cur == 1) {
                count = high * digit + low + 1;
            } else {
                count = (high + 1) * digit;
            }
            res += count;
            digit *= 10;
            num /= 10;
        }
        return res;
    }
}
