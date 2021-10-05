/**
 * @author wwx-sys
 * @time 2021-10-03-10:37
 * @description
 */
public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int rollsSum = 0;
        for (int roll : rolls) {
            rollsSum += roll;
        }
        int diff = mean * (m + n) - rollsSum;
        int average = diff / n, mod = diff % n;
        int[] res = new int[0];
        if (average <= 0 ||average > 6 || (average == 6 && mod > 0)) {
            return res;
        }
        res = new int[n];
        for (int i = 0; i < n; i++) {
            int t = average;
            if (mod != 0) {
                t++;
                mod--;
            }
            res[i] = t;
        }
        return res;
    }
}
