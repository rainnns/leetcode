/**
 * @author wwx-sys
 * @time 2021-12-28-15:05
 * @description 剑指 Offer 57. 和为s的两个数字
 */
public class T57 {

    //双指针
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{nums[l], nums[r]};
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }


    //二分
    public int[] twoSum1(int[] nums, int target) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            int t = target - nums[i];
            int bIndex = binarySearch(nums, t, i + 1, nums.length - 1);
            if (bIndex >= 0) {
                b = nums[bIndex];
                break;
            }
        }
        return new int[]{a, b};
    }

    int binarySearch(int[] nums, int t, int l, int r) {
        if (r < l) {
            return -1;
        }
        int m = (l + r) >> 1;
        if (nums[m] == t) {
            return m;
        } else if (nums[m] < t) {
            return binarySearch(nums, t, m + 1, r);
        } else {
            return binarySearch(nums, t, l, m - 1);
        }
    }
}
