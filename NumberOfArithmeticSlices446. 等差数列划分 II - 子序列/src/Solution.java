import java.util.HashMap;
import java.util.Map;

/**
 * @author wwx-sys
 * @time 2021-08-11-15:56
 * @description
 */
public class Solution {

    //动态规划 + 哈希表
    //由于尾项和公差可以确定一个等差数列，因此我们定义状态 f[i][d] 表示尾项为 nums[i]，公差为 d 的弱等差子序列的个数。
    //代码实现时，由于 nums[i] 的范围很大，所以计算出的公差的范围也很大，我们可以将状态转移数组 f 的第二维用哈希表代替。
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 8, 10};
        System.out.println(new Solution().numberOfArithmeticSlices(nums));
    }


}
