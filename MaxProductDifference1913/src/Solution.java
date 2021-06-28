/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/28 18:56
 */
public class Solution {
    public int maxProductDifference(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int maxSecond = Math.min(nums[0], nums[1]);
        int min = maxSecond;
        int minSecond = max;
        for (int i = 2; i < nums.length; i++) {
            if (max < nums[i]) {
                maxSecond = max;
                max = nums[i];
            } else if (maxSecond < nums[i]) {
                maxSecond = nums[i];
            }

            if (min > nums[i]) {
                minSecond = min;
                min = nums[i];
            } else if (minSecond > nums[i]) {
                minSecond = nums[i];
            }

        }
        return max * maxSecond - min * minSecond;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 5, 9, 7, 4, 8};
        System.out.println(new Solution().maxProductDifference(nums));
    }
}
