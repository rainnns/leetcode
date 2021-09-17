package xiecheng;

/**
 * @author wwx-sys
 * @time 2021-09-16-17:24
 * @description
 */
public class Solution2 {
    public long res;

    public void countDolphin(int n, int m, int[] birthYear, int x) {
        res += n;
        for (int birth : birthYear) {
            if (x < birth) {
                return;
            } else {
                countDolphin(n, m, birthYear, x - birth);
            }
        }
        if (m > x) {
            res -= n;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.countDolphin(5, 5, new int[]{2, 4}, 8);
        System.out.println(solution2.res);
    }


}
