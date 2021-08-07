import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/2 10:58
 */
public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] rectangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(rectangle[i], 101);
        }
        for (int[] time : times) {
            rectangle[time[0] - 1][time[1] -1] = time[2];
        }
        int[] dist = new int[n];
        System.arraycopy(rectangle[k - 1], 0, dist, 0, n);
        dist[k - 1] = 0;
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int minIndex = getArrayMinValueIndex(dist, visited);
            if (minIndex != -1){
                visited.add(minIndex);
                for (int j = 0; j < n; j++) {
                    if (rectangle[minIndex][j] < 101){
                        int update = dist[minIndex] + rectangle[minIndex][j];
                        if (dist[j] > update){
                            dist[j] = update;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i : dist) {
            if (i == 101){
                return -1;
            }
            if (res < i){
                res = i;
            }
        }
        return res;
    }

    public int getArrayMinValueIndex(int[] dist, List<Integer> visitedList) {
        int temp = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visitedList.contains(i) && dist[i] < temp) {
                res = i;
                temp = dist[i];
            }
        }
        return res;
    }


    // 堆优化的Dijkstra算法
    int N = 110, M = 6010;
    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    int[] dist = new int[N];
    boolean[] vis = new boolean[N];
    int n, k, idx;
    int INF = 0x3f3f3f3f;
    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }
    public int networkDelayTime1(int[][] ts, int _n, int _k) {
        n = _n; k = _k;
        Arrays.fill(he, -1);
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            add(u, v, c);
        }
        dijkstra();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }
    void dijkstra() {
        Arrays.fill(vis, false);
        Arrays.fill(dist, INF);
        dist[k] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[1]-b[1]);
        q.add(new int[]{k, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int id = poll[0], step = poll[1];
            if (vis[id]) continue;
            vis[id] = true;
            for (int i = he[id]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[id] + w[i]) {
                    dist[j] = dist[id] + w[i];
                    q.add(new int[]{j, dist[j]});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(new Solution().networkDelayTime(times,4,2));
    }
}
