import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wwx-sys
 * @time 2021-09-13-16:18
 * @description
 */
public class Solution {
    //在代码实现时，我们可以直接保存距离的平方，避免复杂的开方运算。
    //枚举 + 哈希表
    public int numberOfBoomerangs1(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        //先计算每个点到其他点的距离
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[j][i] = dist[i][j] = calculate(points[i], points[j]);
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(dist[i]);
            double candidate = dist[i][0];
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (candidate == dist[i][j]) {
                    count++;
                }
                if (candidate != dist[i][j] || j == n - 1) {
                    res += count * (count - 1);
                    candidate = dist[i][j];
                    count = 1;
                }
            }
        }
        return res;
    }

    public int calculate(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        int t = new Solution().numberOfBoomerangs(points);
        System.out.println(t);
    }

}
