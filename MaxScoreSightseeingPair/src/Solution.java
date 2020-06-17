/**
 * 描述:
 *
 * @author black-leaves
 * @createTime 2020-06-17  17:00
 */

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (j != i + 1 && A[j] <= A[j - 1]) {
                    continue;
                }
                int grade = A[i] + A[j] + i - j;
                if (grade >= max) {
                    max = grade;
                }
            }
        }
        return max;
    }
}
