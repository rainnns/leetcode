/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/16 14:57
 */
public class Solution {
    //二分查找
    public int search(int[] nums, int target) {
        if (nums.length == 0){return 0;}
        int left = 0, right = nums.length - 1;
        if (target < nums[left] || target > nums[right]) {
            return 0;
        }
        int targetIndex = (left + right) / 2;
        while (left <= right) {
            if (nums[targetIndex] < target) {
                left += 1;
            } else if (nums[targetIndex] > target) {
                right -= 1;
            } else {
                break;
            }
            targetIndex = (left + right) / 2;
        }
        if (nums[targetIndex] != target) {
            return 0;
        }
        int ret = 1;
        //向左找
        for (int i = targetIndex - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            }
            ret += 1;

        }
        //向右找
        for (int i = targetIndex + 1; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            }
            ret += 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }
}
