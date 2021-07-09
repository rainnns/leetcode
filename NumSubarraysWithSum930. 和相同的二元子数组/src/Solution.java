import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * 假设原数组的前缀和数组为sum，且子数组 (i,j] 的区间和为 goal，那么 sum[j]−sum[i]=goal。因此我们可以枚举 j ，每次查询满足该等式的 i 的数量。
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += cnt.getOrDefault(sum - goal, 0);
        }
        return ret;
    }

    /**
     * 方法二：滑动窗口
     * 我们令滑动窗口右边界为 right，使用两个左边界 left1 和 left2 表示左区间 [left1,left2)，此时有 left2−left1个区间满足条件
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum2(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}