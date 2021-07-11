import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/11 10:38
 */
public class Solution {
    public int countPalindromicSubsequence(String s) {
        int ret = 0;
        char[] chs = s.toCharArray();
        //可以先遍历一遍，得到每个字母的最后一个出现的位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            map.put(s.charAt(i), i);
        }

        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < chs.length - 2; i++) {
            char currentC = chs[i];
            if (seen.contains(currentC)) {
                continue;
            }
            Set<Character> set = new HashSet<>();
            int end = map.get(chs[i]);
            for (int j = i + 1; j < end ; j++) {
                set.add(chs[j]);
            }
            ret += set.size();
            seen.add(currentC);
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(new Solution().countPalindromicSubsequence(s));
    }
}
