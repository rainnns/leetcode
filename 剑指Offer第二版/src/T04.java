/**
 * @author wwx-sys
 * @time 2021-09-28-10:53
 * @description 剑指 Offer 04. 二维数组中的查找
 */
public class T04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            int flag = matrix[i][j];
            if (target == flag) {
                return true;
            }
            if (target > flag) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
