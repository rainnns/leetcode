import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-10-08-10:10
 * @description 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class T21 {
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if ((nums[l] & 1) == 0 && (nums[r] & 1) == 1) {
                swap(l, r, nums);
                l++;
                r--;
            } else if ((nums[l] & 1) == 1) {
                l++;
            } else if ((nums[r] & 1) == 0) {
                r--;
            }
        }
        return nums;
    }

    public void swap(int l, int r, int[] nums) {
        int t = nums[r];
        nums[r] = nums[l];
        nums[l] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new T21().exchange(nums)));
    }
}
