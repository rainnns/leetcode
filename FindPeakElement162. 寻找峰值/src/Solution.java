/**
 * @author wwx-sys
 * @time 2021-09-15-16:08
 * @description
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean left, right;
            if (i == 0) {
                left = true;
            } else {
                left = nums[i] > nums[i - 1];
            }
            if (i == n - 1) {
                right = true;
            } else {
                right = nums[i] > nums[i + 1];
            }
            if (left && right) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new Solution().findPeakElement(nums));
    }


}
