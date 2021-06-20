/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/20 10:33
 */
public class Solution {
    public String largestOddNumber(String num) {
        int maxOddIndex = 0;
        for (int i = num.length(); i > 0; i--) {
            int number = num.charAt(i - 1) - 48;
            if (number % 2 == 1) {
                maxOddIndex = i;
                return num.substring(0, maxOddIndex);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestOddNumber("52"));
    }
}
