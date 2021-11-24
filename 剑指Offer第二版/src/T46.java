import java.util.LinkedList;

/**
 * @author wwx-sys
 * @time 2021-11-24-10:30
 * @description 剑指 Offer 46. 把数字翻译成字符串
 */
public class T46 {

    //动态规划
    // 数字xi-1xi可被翻译时，f(i) = f(i-2) + f(i-1);
    // 数字xi-1xi不可被翻译时，f(i) = f(i-1);
    public int translateNum(int num) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (num != 0) {
            int mod = num % 10;
            linkedList.addFirst(mod);
            num /= 10;
        }
        int n = linkedList.size();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[0];
            } else {
                if (canBeTranslate(linkedList.get(i - 2), linkedList.get(i - 1))) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n];
    }

    public boolean canBeTranslate(int n1, int n2) {
        if (n1 == 0 || n1 >= 3) {
            return false;
        }
        return n1 != 2 || n2 < 6;
    }
}
