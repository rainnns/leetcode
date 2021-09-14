import java.util.Arrays;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-09-14-10:06
 * @description
 */
public class Solution {
    //双指针
    public String findLongestWord(String s, List<String> dictionary) {
        int n = s.length();
        String res = "";
        for (String dic : dictionary) {
            if (res.length() > dic.length()) {
                continue;
            }
            int p1 = 0, p2 = 0;
            while (p1 < n && p2 < dic.length()) {
                if (s.charAt(p1) == dic.charAt(p2)) {
                    p2++;
                }
                p1++;
            }
            if (p2 == dic.length()) {
                res = compare(dic, res);
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
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");

        System.out.println(new Solution().findLongestWord(s, dictionary));
    }
}
