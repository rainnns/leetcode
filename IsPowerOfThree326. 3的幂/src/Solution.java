/**
 * @author wwx-sys
 * @time 2021-09-23-16:10
 * @description
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    //在题目给定的 323232 位有符号整数的范围内，最大的 3 的幂为 3^19=1162261467。我们只需要判断 n 是否是 3^19 的约数即可。
    //注意：这并不是快速判断 x 的幂的通用做法，当且仅当 x 为质数可用。

    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(28));
    }
}
