/**
 * 描述:
 * 验证回文串
 *
 * @author black-leaves
 * @createTime 2020-06-19  9:47
 */

class Solution {
    //先将字母 和 数字 单独提出，组成新的字符串，再进行判断，
    // 时间复杂度：O(|s|)，其中 |s| 是字符串 ss 的长度。
    //空间复杂度：O(|s|)。由于我们需要将所有的字母和数字字符存放在另一个字符串中，在最坏情况下，新的字符串 sgood 与原字符串 s 完全相同，因此需要使用 O(|s|)的空间。

    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "");
        StringBuilder stringBuilder = new StringBuilder(str).reverse();
        return stringBuilder.toString().equalsIgnoreCase(str);
    }

    //先将字母 和 数字 单独提出，组成新的字符串，再进行判断
    public boolean isPalindrome1(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i -1)) return false;
        }
        return true;
    }

    //直接在原字符串上进行判断，O(1) 空间的算法。
    // Character.isLetterOrDigit(char)判断char是否是数字或字母
    public boolean isPalindrome2(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}