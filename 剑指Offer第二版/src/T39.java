/**
 * @author wwx-sys
 * @time 2021-10-23-10:00
 * @description 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class T39 {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}
