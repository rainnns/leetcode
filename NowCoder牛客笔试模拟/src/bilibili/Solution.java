package bilibili;

/**
 * @author wwx-sys
 * @time 2021-09-13-21:13
 * @description
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // write code here
        int n = prices.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int t = prices[i] - prices[i -1];
            if (t > 0){
                res += t;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] profits = new int[]{1,2,8,3,5,7};
        System.out.println(new Solution().maxProfit(profits));
    }
}
