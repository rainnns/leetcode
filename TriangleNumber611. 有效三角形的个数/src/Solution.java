import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-08-04-15:18
 * @description
 */
public class Solution {
    // 简单枚举
    public int triangleNumber(int[] nums) {
        if (nums.length < 3){return 0;}
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]){
                        res ++;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    //排序 + 二分查找
    //相对于方法一 ， 在找第三条边的时候，没有通过遍历 j + 1 ~ n -1 来查找，而是在该区间内通过 二分查找
    public int triangleNumber2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }

    //排序 + 双指针
    // 将 j 和 k 视为两个同向移动的指针
    public int triangleNumber3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,5,7,9,100};
        System.out.println(new Solution().triangleNumber(nums));
    }
}
