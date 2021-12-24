/**
 * @author wwx-sys
 * @time 2021-12-24-10:35
 * @description剑指 Offer 56 - II.数组中数字出现的次数 II
 */
public class T56_2 {
    //思路是统计每一位上1出现的次数，然后对3取余，最后的结果就是x

    //方法1  遍历
    public int singleNumbers(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                counts[i] += num & 1;
                num >>>= 1;     //无符号右移
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    //方法2 有限状态机
    public int singleNumbers1(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            one = (num ^ one )& ~two;
            two = (num ^ two) & ~one;
        }
        //遍历完所有数字后，各二进制位都处于状态 00 和状态 01 （取决于 “只出现一次的数字” 的各二进制位是 1 还是 0 ），而此两状态是由 one 来记录的（此两状态下 twos 恒为 0 ），因此返回 one 即可。
        return one;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
