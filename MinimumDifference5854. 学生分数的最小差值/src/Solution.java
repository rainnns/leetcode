import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/29 10:33
 */
public class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return 0;
        }
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - k; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{87063,61094,44530,21297,95857,93551,9918};

        System.out.println(new Solution().minimumDifference(nums, 6));
    }
}
