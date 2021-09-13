import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-09-13-17:46
 * @description 先状压，再暴力
 */
public class Solution1 {
    public int maxProduct(String s) {
        int n = s.length();
        int maxN = 1 << n;
        //存储所有的回文子串的状态和长度
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < maxN; i++) {
            if (check(s, i)) {
                list.add(new int[]{i, getLength(i)});
            }
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if ((list.get(i)[0] & list.get(j)[0]) == 0) {
                    res = Math.max(res, list.get(i)[1] * list.get(j)[1]);
                }
            }
        }
        return res;
    }

    public int getLength(int state) {
        int count = 0;
        while (state != 0) {
            if ((state & 1) == 1) {
                count += 1;
            }
            state <<= 1;
        }
        return count;
    }

    public boolean check(String s, int state) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        while (state != 0) {
            if ((state & 1) == 1) {
                stringBuilder.append(s.charAt(index));
            }
            index++;
            state >>= 1;
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(stringBuilder.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct("leetcodecom"));
    }
}
