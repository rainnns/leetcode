/**
 * @author wwx-sys
 * @time 2021-07-30-16:14
 * @description
 */
public class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.toCharArray()[i];
            res += (c - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("FXSHRXW"));
    }
}
