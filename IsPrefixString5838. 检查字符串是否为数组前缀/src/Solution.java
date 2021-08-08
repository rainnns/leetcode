/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/8 10:36
 */
public class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder stringBuffer = new StringBuilder();
        for (String word : words) {
            stringBuffer.append(word);
            if (stringBuffer.length() > s.length()) {
                return false;
            }
            if (stringBuffer.length() == s.length()) {
                break;
            }
        }
        return stringBuffer.toString().equals(s);
    }

    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = new String[]{"i", "love", "leetcode", "apples"};
        System.out.println(new Solution().isPrefixString(s, words));
    }
}
