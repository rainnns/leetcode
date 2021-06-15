import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-03-08-19:46
 * @description
 */
public class Solution {
    List<Integer> t = new ArrayList<Integer>();                //临时数组
    List<List<Integer>> ans = new ArrayList<List<Integer>>();   //结果

    //初步分析，结果应该有 2^n 种， n = nums.length

    //方法一：迭代法实现子集枚举
    //原序列中元素的总数为 n。原序列中的每个数字 ai的状态可能有两种，即「在子集中」和「不在子集中」。我们用 1表示「在子集中」，0表示不在子集中，那么每一个子集可以对应一个长度为 n的 0/1 序列，第 i 位表示 ai是否在子集中
    //复杂度分析
    //时间复杂度：O(n×2^n)。一共 2^n 个状态，每种状态需要 O(n) 的时间来构造子集。
    //空间复杂度：O(n)。即构造子集使用的临时数组 temp的空间代价。
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {  //第i位取不取
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(t));
        }

        return ans;
    }


    //方法二 ： 递归法实现子集枚举
    public List<List<Integer>> subsets2(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    //dfs(cur,n) 参数表示当前位置是 cur，原序列总长度为 n。原序列的每个位置在答案序列中的状态有被选中和不被选中两种，我们用 t 数组存放已经被选出的数字。
    //在进入 dfs(cur,n)之前 [0,cur−1] 位置的状态是确定的，而[cur,n−1] 内位置的状态是不确定的，dfs(cur,n)需要确定 cur位置的状态，然后求解子问题 dfs(cur+1,n)。
    //对于 cur位置，我们需要考虑 a[cur]取或者不取，
    //如果取，我们需要把 a[cur]放入一个临时的答案数组中（即上面代码中的 t），再执行 dfs(cur+1,n)，执行结束后需要对 t进行回溯；
    //如果不取，则直接执行 dfs(cur+1,n)。在整个递归调用的过程中，cur 是从小到大递增的，当 cur 增加到 n 的时候，记录答案并终止递归。
    //可以看出二进制枚举的时间复杂度是 O(2^n)
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }



}
