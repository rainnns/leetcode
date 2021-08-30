import java.util.Arrays;


/**
 * @author wwx-sys
 * @time 2021-08-30-15:51
 * @description
 */
public class Solution {
    int n;
    int sum;
    int[] pre;

    public Solution(int[] w) {
        n = w.length;
        sum = Arrays.stream(w).sum();
        pre = new int[n];
        pre[0] = w[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int r = (int) (Math.random() * sum);
        return binarySearch(r);
    }

    public int binarySearch(int x) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (pre[mid] <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 3};
        Solution s = new Solution(w);
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
    }
}
