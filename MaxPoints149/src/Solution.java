import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/24 16:44
 */
class Solution {



    /**
     * 时间复杂度：O(n^2×log m)，其中 n 为点的数量，m 为横纵坐标差的最大值。最坏情况下我们需要枚举所有 n 个点，枚举单个点过程中需要进行 O(n) 次最大公约数计算，单次最大公约数计算的时间复杂度是 O(log m)，因此总时间复杂度为 O(n^2 × log m)。
     *
     * 空间复杂度：O(n)，其中 n 为点的数量。主要为哈希表的开销。
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                //在本题中，因为点的横纵坐标取值范围均为[- 10^4,  10^4]，所以斜率 slope=my/mx中，mx 落在区间[-2 *10^4, 2 *10^4]  内，my 落在区间 [0, 2 *10^4]内。注意到 32位整数的范围远超这两个区间，因此我们可以用单个 32 位整型变量来表示这两个整数。具体地，我们令 val=y + x * 20001 即可
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    /**
     * 最大公约数
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}