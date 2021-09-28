import java.util.HashSet;

/**
 * @author wwx-sys
 * @time 2021-09-28-10:08
 * @description 剑指 Offer 03. 数组中重复的数字
 */
public class FindRepeatNumber03 {
    //HashSet
    // O(n) ; O(n)
    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    //原地交换；跟计数排序的思想差不多
    // O(n) ; O(1)
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            int t = nums[nums[i]];
            if (t == nums[i]) {
                return nums[i];
            }
            nums[nums[i]] = nums[i];
            nums[i] = t;
        }
        return -1;
    }

}
