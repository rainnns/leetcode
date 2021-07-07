import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final int MOD = 1000000007;

    //时间超时
    public int countPairs2(int[] deliciousness) {
        int ret = 0;
        for (int i = 0; i < deliciousness.length - 1; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                if (sum != 0 && (sum & (sum - 1)) == 0) {
                    ret += 1;
                }
            }
        }
        return ret % MOD;
    }

    /**
     * 上述朴素解法存在同一个元素被重复计算的情况，因此可以使用哈希表减少重复计算，降低时间复杂度。具体做法是，使用哈希表存储数组中的每个元素的出现次数，遍历到数组 deliciousness 中的某个元素时，在哈希表中寻找与当前元素的和等于 2 的幂的元素个数，然后用当前元素更新哈希表。由于遍历数组时，哈希表中已有的元素的下标一定小于当前元素的下标，因此任意一对元素之和等于 2 的幂的元素都不会被重复计算。
     * 令 maxVal 表示数组 deliciousness 中的最大元素，则数组中的任意两个元素之和都不会超过 maxVal×2。令 maxSum=maxVal×2，则任意一顿大餐的美味程度之和为不超过 maxSum 的某个 2 的幂。
     *
     *
     *
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }

        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deliciousness) {
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }


    public static void main(String[] args) {
        int[] deliciousness = new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234};
        System.out.println(new Solution().countPairs(deliciousness));
//        System.out.println(new Solution().isMultiBy2(2));
    }

}
