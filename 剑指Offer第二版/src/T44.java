/**
 * @author wwx-sys
 * @time 2021-11-18-16:56
 * @description 剑指 Offer 44. 数字序列中某一位的数字
 */
public class T44 {

    //分三步，第一步计算出所在的digit，第二步计算所在的数字，第三步计算数字所在的位数
    public int findNthDigit(int n) {
        long count = 9, start = 1;
        int digit = 1;
        while (n > count) {//1
            n -= count;
            digit++;
            start *= 10;
            count = 9 * start * digit;
        }
        long num = start + (n - 1) / digit; //2
        return Long.toString(num).charAt((n - 1) % digit) - '0';//3
    }
}
