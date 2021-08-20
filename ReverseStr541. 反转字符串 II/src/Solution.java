/**
 * @author wwx-sys
 * @time 2021-08-20-15:15
 * @description
 */
public class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] res = s.toCharArray();
        int i = 0;
        while (i < n) {
            int l = i, r = i + k - 1;
            if (n - i < k) {
                r = n - 1;
            }
            while (l < r) {
                char temp = res[l];
                res[l] = res[r];
                res[r] = temp;
                l++;
                r--;
            }
            i += 2 * k;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg",2));
    }
}
