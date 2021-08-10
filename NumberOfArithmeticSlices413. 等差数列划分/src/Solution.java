/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/10 17:41
 */
public class Solution {
    //双指针
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        int i = 0;
        while (i < n - 2) {
            int dif = nums[i + 1] - nums[i];
            int j = i + 1, k = i + 2;
            if (nums[k] - nums[j] != dif) {
                i++;
                continue;
            }
            while (k < n && nums[k] - nums[j] == dif) {
                k++;
                j++;
            }
            int len = j - i;
            res += (len * (len - 1)) / 2;
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 5, 7};
        System.out.println(new Solution().numberOfArithmeticSlices(nums));
    }
}
