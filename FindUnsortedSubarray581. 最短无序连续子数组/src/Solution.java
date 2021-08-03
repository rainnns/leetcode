import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-08-03-16:38
 * @description
 */
public class Solution {
    //模拟
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int startIndex = nums.length;
        int endIndex = nums.length - 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                int t = i;
                while (t > 0 && nums[t] < nums[t - 1]) {
                    int temp = nums[t - 1];
                    nums[t - 1] = nums[t];
                    nums[t] = temp;
                    t -= 1;
                }
                if (startIndex > t) {
                    startIndex = t;
                }
                endIndex = i;
            }
        }
        if (startIndex == nums.length) {
            return 0;
        }

        return endIndex - startIndex + 1;
    }

    // 排序
    public int findUnsortedSubarray2(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    //一次遍历 , 双指针
    public int findUnsortedSubarray3(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 2};
        System.out.println(new Solution().findUnsortedSubarray3(nums));
    }
}
