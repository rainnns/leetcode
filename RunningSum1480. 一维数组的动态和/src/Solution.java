/**
 * @author wwx-sys
 * @time 2021-08-28-9:37
 * @description
 */
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
