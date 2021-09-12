import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wwx-sys
 * @time 2021-09-08-9:31
 * @description
 */
public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int curr = 0;
        for (int i = k; i > 0; i--) {
            while (curr < n) {
                int c = arr[curr][0];
                if (w < c) {
                    break;
                }
                queue.offer(arr[curr][1]);
                curr++;
            }
            if (queue.isEmpty()) {
                break;
            }
            w += queue.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 2};
        System.out.println(new Solution().findMaximizedCapital(10, 0, profits, capital));
    }
}
