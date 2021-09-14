import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-09-14-10:47
 * @description 我们可以先将 dictionary 依据字符串长度的降序和字典序的升序进行排序，然后从前向后找到第一个符合条件的字符串直接返回即可。
 */
public class Solution2 {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });
        for (String dic : dictionary) {
            int i = 0, j = 0;
            while (i < dic.length() && j < s.length()) {
                if (dic.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == dic.length()){
                return dic;
            }
        }
        return "";
    }
}
