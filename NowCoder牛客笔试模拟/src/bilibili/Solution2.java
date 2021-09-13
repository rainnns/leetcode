package bilibili;

/**
 * @author wwx-sys
 * @time 2021-09-13-21:28
 * @description
 */
public class Solution2 {
    int[][] grid;
    int m, n;
    int res = Integer.MAX_VALUE;

    /**
     * @param grid int整型二维数组
     * @return int整型
     */
    public int minPathSum(int[][] grid) {
        // write code here
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        go(0, 0, 0, new int[m][n]);
        return res;
    }

    public void go(int x, int y, int t, int[][] vis) {
        if (x == m - 1 && y == n - 1) {
            res = Math.min(res, t + grid[x][y]);
            return;
        }

        vis[x][y] = 1;
        if (x < m - 1 && vis[x + 1][y] == 0) {
            go(x + 1, y, t + grid[x][y], vis);
        }
        if (y < n - 1 && vis[x][y + 1] == 0) {
            go(x, y + 1, t + grid[x][y], vis);
        }
        if (x > 0 && vis[x - 1][y] == 0) {
            go(x - 1, y, t + grid[x][y], vis);
        }
        if (y > 0 && vis[x][y - 1] == 0) {
            go(x, y - 1, t + grid[x][y], vis);
        }
        vis[x][y] = 0;

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,3,1,4},{4,6,3,1},{4,3,1,2},{2,4,1,3}};
        System.out.println(new Solution2().minPathSum(grid));
    }
}
