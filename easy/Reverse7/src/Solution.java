import static java.lang.Math.pow;

/**
 * @author wwx-sys
 * @time 2021-05-31-16:01
 * @description
 */
public class Solution {
    public int reverse(int x) {
        int INT_MAX = (int) (pow(2, 31) - 1);
        int INT_MIN = (int) (-pow(2, 31));
        int result = 0;
        while (x != 0) {
            //但是题目要求不允许使用 64 位整数，即运算过程中的数字必须在 32 位有符号整数的范围内，因此我们不能直接对最后的result进行判断，需要在其乘以10之前，还在32位整数的范围内的时候对其进行判断 。
            if (result < INT_MIN / 10 || result > INT_MAX / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
