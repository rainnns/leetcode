import java.util.Arrays;
import java.util.Comparator;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/2 16:27
 */
public class Solution {

    /**
     * 方法一 排序 + 贪心
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ret = 0;
        for (int cost : costs) {
            if (cost <= coins){
                coins -= cost;
                ret += 1;
            }
            else {
                return ret;
            }
        }
        return ret;
    }

    /**
     * 计数排序 + 贪心
     * 由于数组 costs中的元素不会超过 10^5，因此可以使用计数排序，将时间复杂度降低到线性。
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream2(int[] costs, int coins) {
        int[] freq = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                count += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return count;
    }




    public static void main(String[] args) {
        int[] costs = new int[]{10,6,8,7,7,8};
        int coins = 20;
        System.out.println(new Solution().maxIceCream(costs, coins));
    }

}
