/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/23 17:17
 */
public class Solution {
    /**
     * you need to treat n as an unsigned value
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        int length = 32;
        for (int i = 0; i < length; i++) {
            if ((n & (1 << i)) != 0) {
                count += 1;
            }
        }
        return count;
    }


    /**
     * 观察这个运算：n & (n−1)，其预算结果恰为把 n 的二进制位中的最低位的 1 变为 0之后的结果。
     *
     * 如：6 & (6−1)=4,6=(110)2,4=(100)2, 运算结果 4 即为把 6 的二进制位中的最低位的 1 变为 0 之后的结果。
     *
     * 这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，我们不断让当前的 n 与 n−1做与运算，直到 n变为 0 即可。因为每次运算会使得 n 的最低位的 1被翻转，因此运算次数就等于 n 的二进制位中 1 的个数。
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight((int) Math.pow(2, 32) - 1));
    }
}
