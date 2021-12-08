import java.util.HashMap;
import java.util.Map;

/**
 * @author wwx-sys
 * @time 2021-12-08-15:24
 * @description 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class T48 {

    //动态规划 + 哈希表
    // O(N)  O(1)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, last = 0;
        for (int i = 0; i < n; i++) {
            char t = s.charAt(i);
            int lastIndex = map.getOrDefault(t, -1);
            last = last < (i - lastIndex) ? last + 1 : (i - lastIndex);
            map.put(t, i);
            max = Math.max(max, last);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abacbdcc";
        System.out.println(new T48().lengthOfLongestSubstring(str));
    }
}
