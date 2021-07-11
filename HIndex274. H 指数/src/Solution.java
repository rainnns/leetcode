import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/11 9:42
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (h <= citations[i]) {
                return h;
            }
        }
        return 0;
    }

    //计数排序
    public int hIndex2(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            if (citation >= n) {
                counter[n]++;
            } else {
                counter[citation]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};
        System.out.println(new Solution().hIndex(citations));
    }
}
