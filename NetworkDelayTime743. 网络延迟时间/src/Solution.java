import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(new Solution().networkDelayTime(times,4,2));
    }
}
