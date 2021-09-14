import java.util.Arrays;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-09-14-10:59
 * @description 动态规划预处理，来判断子序列
 */
public class Solution3 {

    public String findLongestWord(String s, List<String> dictionary) {
        int n = s.length();
        int[][] dp = new int[n + 1][26];
        Arrays.fill(dp[n], n);
        for (int i = n - 1; i >= 0; i--) {
            int t = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (j == t) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        String res = "";
        for (String dic : dictionary) {
            boolean isSatisfied = true;
            int j = 0;
            for (int i = 0; i < dic.length(); i++) {
                if (dp[j][dic.charAt(i) - 'a'] == n) {
                    isSatisfied = false;
                    break;
                }
                j = dp[j][dic.charAt(i) - 'a'] + 1;
            }
            if (isSatisfied) {
                res = compare(res, dic);
            }
        }
        return res;
    }

    public String compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() > s2.length() ? s1 : s2;
        }
        return s1.compareTo(s2) < 0 ? s1 : s2;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa");
        System.out.println(new Solution3().findLongestWord(s, dictionary));
    }
}
