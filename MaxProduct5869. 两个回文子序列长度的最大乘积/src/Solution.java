/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/12 11:06
 */
public class Solution {
    int res = 0;

    public int maxProduct(String s) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        dfs(s, s1, s2, 0);
        return res;
    }

    public void dfs(String s, StringBuilder subString1, StringBuilder subString2, int i) {
        if (check(subString1.toString()) && check(subString2.toString())) {
            res = Math.max(res, subString1.length() * subString2.length());
        }
        if (i == s.length()) {
            return;
        }
        dfs(s, subString1.append(s.charAt(i)), subString2, i + 1);
        subString1.delete(subString1.length() - 1, subString1.length());
        dfs(s, subString1, subString2.append(s.charAt(i)), i + 1);
        subString2.delete(subString2.length() - 1, subString2.length());
        dfs(s, subString1, subString2, i + 1);
    }

    public boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct("leetcodecom"));
    }
}
