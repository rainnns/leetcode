/**
 * @author wwx-sys
 * @time 2021-12-16-13:10
 * @description 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class T53 {
    //由于数组 nums 中元素都为整数，因此可以分别二分查找 target 和 target−1 的右边界，将两结果相减并返回即可。
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


    public int search1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int t = (l + r) >> 1;
            if (nums[t] < target) {
                l = t + 1;
            } else if (nums[t] > target) {
                r = t;
            } else {
                l = t;
                break;
            }
        }
        if (nums[l] != target) {
            return 0;
        }
        int lt = l, rt = l;
        while (lt >= 0 && nums[lt] == target) {
            lt--;
        }
        while (rt < n && nums[rt] == target) {
            rt++;
        }
        return rt - lt - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(new T53().search(nums, 7));
    }
}
