/**
 * @author wwx-sys
 * @time 2021-11-08-15:20
 * @description 剑指 Offer 42. 连续子数组的最大和
 */
public class T42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int last = max;
        for (int i = 1; i < n; i++) {
            if (last > 0){
                last += nums[i];
            }
            else {
                last = nums[i];
            }
            max = Math.max(max,last);
        }
        return max;
    }
}
