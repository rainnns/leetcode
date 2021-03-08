import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-03-08-19:46
 * @description
 */
public class Solution {
    //初步分析，结果应该有 2^n 种， n = nums.length
    //方法一：迭代法实现子集枚举
    //原序列中元素的总数为 n。原序列中的每个数字 ai的状态可能有两种，即「在子集中」和「不在子集中」。我们用 1表示「在子集中」，0表示不在子集中，那么每一个子集可以对应一个长度为 n的 0/1 序列，第 i 位表示 ai是否在子集中
    //复杂度分析
    //时间复杂度：O(n×2^n)。一共 2^n 个状态，每种状态需要 O(n) 的时间来构造子集。
    //空间复杂度：O(n)。即构造子集使用的临时数组 temp的空间代价。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            temp.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {  //第i位取不取
                    temp.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(temp));
        }

        return res;
    }
}
