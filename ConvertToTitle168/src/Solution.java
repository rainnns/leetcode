/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/29 16:35
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber --;
            res.append((char) (columnNumber % 26 + 65));
            columnNumber = columnNumber / 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(28));
    }
}
