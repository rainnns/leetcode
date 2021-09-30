/**
 * @author wwx-sys
 * @time 2021-09-30-17:15
 * @description 剑指 Offer 13. 机器人的运动范围
 */
public class T13 {
    int res;
    int m, n, k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        int[][] vis = new int[m][n];
        dfs(0, 0, 0, 0, vis);
        return res;
    }

    public void dfs(int i, int j, int si, int sj, int[][] vis) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] != 0 || si + sj > k) {
            return;
        }
        res++;
        vis[i][j] = 1;
        dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj, vis);
        dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8, vis);
    }

    public static void main(String[] args) {
        System.out.println(new T13().movingCount(3, 1, 0));
    }
}
