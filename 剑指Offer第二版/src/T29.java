/**
 * @author wwx-sys
 * @time 2021-10-11-11:36
 * @description 剑指 Offer 29. 顺时针打印矩阵
 */
public class T29 {

    //模拟
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;

    }

    //递归

    //0,1,2,3分别表示：右-下-左-上
    int direction = 0;
    //结果
    int[] result = null;
    //添加结果数据的下标
    int index = 0;
    //当前位置是否已经遍历过
    boolean[][] pass = null;

    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        pass = new boolean[matrix.length][matrix[0].length];
        result = new int[matrix.length * matrix[0].length];
        dfs(matrix, 0, 0);
        return result;


    }
     public void dfs(int[][] arr, int i, int j) {
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1 || pass[i][j]) {
            direction = (direction + 1) % 4;
            return;
        }
        if (index == result.length){
            return;
        }
        result[index++] = arr[i][j];
        pass[i][j] = true;
        while (index != result.length) {
            int ii = (direction == 0 || direction == 2) ? i : ((direction == 1 ? i + 1 : i - 1));
            int jj = (direction == 1 || direction == 3) ? j : ((direction == 0 ? j + 1 : j - 1));
             //上一步return后direction+1后，i和j已经越界了
            dfs(arr, ii, jj);
        }
    }

}
