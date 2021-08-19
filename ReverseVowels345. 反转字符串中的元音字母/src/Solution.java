import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wwx-sys
 * @time 2021-08-19-15:07
 * @description
 */
public class Solution {
    public String reverseVowels(String s) {
        char[] v = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowels =new HashSet<>();
        for (char c : v) {
            vowels.add(c);
        }
        char[] res = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!vowels.contains(res[l])) {
                l++;
            }
            if (!vowels.contains(res[r])) {
                r--;
            }
            if (vowels.contains(res[l]) && vowels.contains(res[r])) {
                char temp = res[l];
                res[l] = res[r];
                res[r] = temp;
                l++;
                r--;
            }
        }
        return new String(res);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
    }
}
