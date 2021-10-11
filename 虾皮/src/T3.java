/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/11 20:09
 */
public class T3 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param x string字符串 -50.0 < x < 50.0
     * @param n int整型 -2^31 <= n <= (2^31 - 1)，n 是整数
     * @return string字符串
     */
    public String pow(String x, int n) {
        // write code here
        //精度
        int d = 0;
        if (x.contains(".")) {
            d = x.split("\\.")[1].length();
        }
        double num = Double.parseDouble(x);
        double res = recur(num, n);
        return String.format("%." + d + "f", res);
    }

    public double recur(double num, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return (1 / num) * recur(1 / num, -n - 1);
        }
        double t = recur(num * num, n / 2);
        if (Double.MAX_VALUE / Math.abs(t) < Math.abs(t)) {
            return 0;
        }
        return n % 2 == 0 ? t : num * t;
    }

    public static void main(String[] args) {

    }
}
