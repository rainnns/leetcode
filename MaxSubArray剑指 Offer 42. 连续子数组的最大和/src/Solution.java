/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/17 22:36
 */
public class Solution {

    //动态规划

    /**
     * 设动态规划列表 dp ，dp[i] 代表以元素 nums[i] 为结尾的连续子数组最大和。
     * 为何定义最大和 dp[i] 中必须包含元素 nums[i] ：保证 dp[i] 递推到 dp[i+1] 的正确性；如果不包含 nums[i] ，递推时则不满足题目的 连续子数组 要求。
     * 转移方程： 若 dp[i−1]≤0 ，说明 dp[i−1] 对 dp[i] 产生负贡献，即 dp[i−1]+nums[i] 还不如 nums[i]本身大。
     * 当 dp[i−1]>0时：执行 dp[i]=dp[i−1]+nums[i]；
     * 当 dp[i−1]≤0 时：执行 dp[i]=nums[i]；
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int former = 0;//用于记录dp[i-1]的值，对于dp[0]而言，其前面的dp[-1]=0
        int cur;//用于记录dp[i]的值
        for (int num : nums) {
            cur = num + Math.max(former,0);
            former = cur;
            max = Math.max(max,cur);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
