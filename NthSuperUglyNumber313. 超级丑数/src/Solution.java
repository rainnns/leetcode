import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author wwx-sys
 * @time 2021-08-09-15:27
 * @description
 */
public class Solution {

    //最小堆
    public int nthSuperUglyNumber(int n, int[] primes) {
        //用Integer会造成数据太大溢出，这里用Long来存
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            ugly = (int) cur;
            for (int prime : primes) {
                long next = prime * cur;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    //动态规划
    //定义数组 dp，其中 dp[i] 表示第 i 个超级丑数，第 n个超级丑数即为 dp[n]。
    //由于最小的超级丑数是 111，因此 dp[1]=1
    //如何得到其余的超级丑数呢？创建与数组 primes 相同长度的数组 pointers，表示下一个超级丑数是当前指针指向的超级丑数乘以对应的质因数。初始时，数组 pointers 的元素值都是 1。
    //当2≤i≤n 时，令 dp[i]=min{dp[pointers[j]]×primes[j]}，然后对于每个 0≤j<m，分别比较 dp[i] 和 dp[pointers[j]]×primes[j] 是否相等，如果相等则将 pointers[j] 加 1。
    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] primes = new int[]{2, 7, 13, 19};
        System.out.println(new Solution().nthSuperUglyNumber1(12, primes));


//        long a = Integer.MAX_VALUE + 1;
//        System.out.println(Integer.MAX_VALUE );
//        System.out.println((int) a);
    }
}
