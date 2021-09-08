/**
 * @author wwx-sys
 * @time 2021-09-07-15:25
 * @description
 */
public class Solution {
    public int balancedStringSplit(String s) {
        int n = s.length();
        int d = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                d++;
            } else {
                d--;
            }
            if (d == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("RLRRRLLRLL"));
    }
}
