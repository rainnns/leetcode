/**
 * @author wwx-sys
 * @time 2021-09-26-19:53
 * @description
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;   //进位结果
            a = a ^ b;                  //无进位结果
            b = carry;                  //循环把进位结果和无进位结果相加
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSum(-7, -3));
    }
}
