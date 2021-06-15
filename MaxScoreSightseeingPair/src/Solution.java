
/**
 * 描述:
 *
 * @author black-leaves
 * @createTime 2020-06-17  17:00
 */

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        if (A.length == 0) return 0;
        int mx = A[0] + 0;
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, mx + A[i] - i);
            mx = Math.max(mx, A[i] + i);
        }
        return max;
    }
}
