/**
 * @author wwx-sys
 * @time 2021-08-21-14:54
 * @description
 */
public class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        char last = chars[0];
        int res = 1;
        int lastCount = 1;
        int slow = 1;
        for (int i = 1; i < n; i++) {
            if (chars[i] == last) {
                lastCount++;
                if (i == n - 1) {
                    int t = calLastCharLength(lastCount, chars, slow);
                    res += t;
                    slow += t;
                }
            } else {
                //先记录之前重复的字符长度
                int t = calLastCharLength(lastCount, chars, slow);
                res += t;
                slow += t;
                //然后再记录新字符
                res++;
                last = chars[i];
                lastCount = 1;
                chars[slow] = last;
                slow++;
            }
        }

        return res;
    }

    public int calLastCharLength(int lastCount, char[] chars, int startIndex) {
        int res = 0;
        if (lastCount == 1) {
            return 0;
        }
        int mod = lastCount;
        while (lastCount > 9) {
            res++;
            mod = lastCount % 10;
            lastCount = lastCount / 10;
            chars[startIndex] = (char) ('0' + lastCount);
            startIndex++;
        }
        res++;
        chars[startIndex] = (char) ('0' + mod);
        return res;
    }


    public int compress1(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(new Solution().compress(chars));

        int newLength = new Solution().compress(chars);
        for (int i = 0; i < newLength; i++) {
            System.out.println(chars[i]);
        }
    }
}
