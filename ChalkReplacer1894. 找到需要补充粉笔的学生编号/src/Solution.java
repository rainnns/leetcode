/**
 * @author wwx-sys
 * @time 2021-09-10-17:21
 * @description
 */
public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;
        int curr = 0;
        for (int j : chalk) {
            sum += j;
        }
        long mod = k % sum;
        while (true) {
            if (mod < chalk[curr]) {
                return curr;
            }
            mod -= chalk[curr];
            curr++;
            curr %= n;
        }
    }

    public static void main(String[] args) {
        int[] chalk = new int[]{5, 1, 5};
        int k = 1000000;
        System.out.println(new Solution().chalkReplacer(chalk, k));
    }
}
