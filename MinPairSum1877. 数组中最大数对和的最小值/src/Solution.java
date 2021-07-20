import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-07-20-15:11
 * @description
 */
public class Solution {
    //排序 + 贪心
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        int l = 0 , r = nums.length -1;
        while (l < r){
            if (nums[l] + nums[r] > ret){
                ret = nums[l] + nums[r];
            }
            l += 1;
            r -= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums =  new int[]{3,5,4,2,4,6};
        System.out.println(new Solution().minPairSum(nums));
    }
}
