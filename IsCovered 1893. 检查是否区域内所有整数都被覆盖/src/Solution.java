/**
 * @author wwx-sys
 * @time 2021-07-23-9:19
 * @description
 */
public class Solution {
    //朴素做法  记 ranges 的长度为 n，需要计算的区间范围为 l，则上述做法的时间复杂度为 O(n*l)。

    public boolean isCovered1(int[][] ranges, int left, int right) {
        int[] counts = new int[51];
        for (int[] range : ranges) {
            int start_i = range[0];
            int end_i = range[1];
            for (int i = start_i; i <= end_i; i++) {
                counts[i] += 1;
            }
        }
        for (int i = left; i <= right; i++) {
            if (counts[i] == 0) {
                return false;
            }
        }
        return true;
    }

    // 差分数组
    // 时间复杂度：O(n+l)
    //我们可以用差分数组 diff 维护相邻两个整数的被覆盖区间数量变化量，其中 diff[i] 对应覆盖整数 i 的区间数量相对于覆盖 i−1 的区间数量变化量。
    // 这样，当遍历到闭区间 [l,r] 时，l 相对于 l−1 被覆盖区间数量多 1，r+1 相对于 r 被覆盖区间数量少 1。
    // 对应到差分数组上，我们需要将 diff[l] 加上 1，并将 diff[r+1] 减去 1。

    //在维护完差分数组 diff 后，我们遍历 diff 求前缀和得出覆盖每个整数的区间数量。下标 i 对应的被覆盖区间数量即为初始数量 0 加上 [1, i] 闭区间的变化量之和。
    // 在计算被覆盖区间数量的同时，我们可以一并判断 [left,right] 闭区间内的所有整数是否都被覆盖。
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];   // 差分数组
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }
        // 前缀和
        int curr = 0;
        for (int i = 1; i <= 50; ++i) {
            curr += diff[i];
            if (i >= left && i <= right && curr <= 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int left = 2;
        int right = 5;
        System.out.println(new Solution().isCovered(ranges, left, right));
    }
}
