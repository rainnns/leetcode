/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/12 11:06
 */
public class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n ; i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        return 0;
    }
}
