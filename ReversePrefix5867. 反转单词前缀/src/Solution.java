/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/12 10:39
 */
public class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == ch){
                return  new StringBuffer(word.substring(0,i + 1)).reverse().append(word.substring(i + 1)).toString();
            }
        }
        return word;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reversePrefix("abcdefz",'z'));
    }
}
