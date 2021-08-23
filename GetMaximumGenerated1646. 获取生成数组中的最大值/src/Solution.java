/**
 * @author wwx-sys
 * @time 2021-08-23-15:26
 * @description
 */
public class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = nums[1];
        for (int i = 2; i <= n; i++) {
            nums[i] = i % 2 == 0 ? nums[i / 2] : (nums[i / 2] + nums[i - i / 2]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMaximumGenerated(7));
    }
}
