/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/15 9:52
 */
public class T1 {
    int n;
    int m;
    int res = Integer.MAX_VALUE;

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算出给定二维数组的最短路径
     *
     * @param data int整型二维数组
     * @return int整型
     */
    public int findShortestPath(int[][] data) {
        // write code here
        n = data.length;
        if (n == 0) {
            return 0;
        }
        m = data[0].length;
        int[][] vis = new int[m][n];
        recur(data, 0, 0, vis, 0);
        return res;
    }

    public void recur(int[][] data, int i, int j, int[][] vis, int cost) {
        if (i == m - 1 && j == n - 1) {
            res = Math.min(res, cost + data[i][j]);
            return;
        }
        if (i < m && j < n && vis[i][j] == 0) {
            vis[i][j] = 1;
            recur(data, i + 1, j, vis, cost + data[i][j]);
            recur(data, i, j + 1, vis, cost + data[i][j]);
            vis[i][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                {2, 3, 1, 4}, {4, 6, 3, 1}, {4, 3, 1, 2}, {2, 4, 1, 3}
        };
        System.out.println(new T1().findShortestPath(data));
    }

}
