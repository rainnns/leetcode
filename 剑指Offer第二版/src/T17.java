import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-10-02-15:58
 * @description 剑指 Offer 17. 打印从1到最大的n位数
 */
public class T17 {

    //傻瓜解法
    public int[] printNumbers1(int n) {
        int[] arr = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    //递归全排列；考虑到大数情况，使用String来存储
    int[] res;
    char[] num;
    int n, count;

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) (Math.pow(10, n) - 1)];
        num = new char[n];
        dfs(0);
        return res;
    }

    public void dfs(int x) {
        if (x == n) {
            String t = String.valueOf(num);
            int curNum = Integer.parseInt(t);
            if (curNum != 0) {
                res[count++] = curNum;
            }
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[x] = i;
            dfs(x + 1);
        }
    }
}
