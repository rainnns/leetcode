import java.util.PriorityQueue;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/8 10:43
 */
public class Solution {

    //最大堆,用优先队列模拟最大堆
    //复杂度 O（log n）
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int pile : piles) {
            queue.add(pile);
        }
        for (int i = k; i > 0; i--) {
            int cur = queue.poll();
            cur -= cur / 2;
            queue.add(cur);
        }
        int res = 0;
        for (int pile : queue) {
            res += pile;
        }
        return res;
    }


    //超过时间限制
    public int minStoneSum1(int[] piles, int k) {
        int n = piles.length;
        while (k > 0) {
            int maxIndex = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (piles[i] > piles[maxIndex]) {
                    maxIndex = i;
                }
            }
            piles[maxIndex] -= piles[maxIndex] / 2;
            k--;
        }
        int res = 0;
        for (int pile : piles) {
            res += pile;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{4, 3, 6, 7};
        int k = 3;
        System.out.println(new Solution().minStoneSum(piles, k));
    }
}
