/**
 * @author wwx-sys
 * @time 2021-09-30-18:21
 * @description 剑指 Offer 14- I. 剪绳子
 */
public class T14 {
    //数学推导下，切为多段长度为3绳子乘积最大
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int num = n / 3, mod = n % 3;
        if (mod == 0) {
            return (int) Math.pow(3, num);
        } else if (mod == 1) {
            return (int) (Math.pow(3, num - 1) * 4);
        }
        return (int) (Math.pow(3, num) * 2);
    }

    public static void main(String[] args) {
        System.out.println(new T14().cuttingRope(12));
    }
}
