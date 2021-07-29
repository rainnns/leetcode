import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-07-29-15:00
 * @description
 */
public class Solution {
    // 第 level 层的起始节点值
    int getStart(int level) {
        return (int)Math.pow(2, level - 1);
    }
    // 第 level 层的结束节点值
    int getEnd(int level) {
        int a = getStart(level);
        return a + a - 1;
    }
    public List<Integer> pathInZigZagTree(int n) {
        // 计算 n 所在层级
        int level = 1;
        while (getEnd(level) < n) level++;

        int[] ans = new int[level];
        int idx = level - 1, cur = n;
        while (idx >= 0) {
            ans[idx--] = cur;
            int tot = (int)Math.pow(2, level - 1);
            int start = getStart(level), end = getEnd(level);
            if (level % 2 == 0) {
                // 当前层为偶数层，则当前层节点「从右往左」数值递增，相应计算上一层下标也应该「从右往左」
                int j = tot / 2;
                for (int i = start; i <= end; i += 2, j--) {
                    if (i == cur || (i + 1) == cur) break;
                }
                int prevStart = getStart(level - 1);
                while (j-- > 1) prevStart++;
                cur = prevStart;
            } else {
                // 当前层为奇数层，则当前层节点「从左往右」数值递增，相应计算上一层下标也应该「从左往右」
                int j = 1;
                for (int i = start; i <= end; i += 2, j++) {
                    if (i == cur || (i + 1) == cur) break;
                }
                int prevEnd = getEnd(level - 1);
                while (j-- > 1) prevEnd--;
                cur = prevEnd;
            }
            level--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : ans) list.add(i);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pathInZigZagTree(15));
    }
}
