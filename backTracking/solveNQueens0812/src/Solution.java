import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wwx-sys
 * @time 2021-03-12-15:22
 * @description 八皇后
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens2(int n) {
        int[] cols = new int[n];
        headerIndex(cols);
        return result;
    }

    private void headerIndex(int[] cols) {
        int n = cols.length;
        if (cols[0] >= n) {      //无解
            return;
        }

        //先重置除了第一行之外的其他行数据
        for (int i = 1; i < n; i++) {
            cols[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            while (is_inline(cols, i)) {
                getNumber(i, cols);
//                cols[i] += 1;
                if (cols[i] == -1) {
                    cols[0] += 1;
                    headerIndex(cols);
                    return;
                }
            }
        }
        toString(cols);
        cols[0] += 1;
        headerIndex(cols);
    }


    private void getNumber(int nowRowIndex, int[] cols) {
//        while (!is_inline(cols, nowRowIndex)) {
        if (cols[nowRowIndex] >= cols.length - 1) {
            cols[nowRowIndex] = -1;
            return;
        }
        cols[nowRowIndex] += 1;
//        }
    }

    private boolean is_inline(int r1, int c1, int r2, int c2) {

        if (r1 == r2 || c1 == c2) {
            return true;
        }

        return (c2 - c1) / (r2 - r1) == 1 || (c2 - c1) / (r2 - r1) == -1;
    }


    //第nowRowIndex的数，是否与前nowRowIndex -1 的这些数构成不在同行、同列、同对角线
    public boolean is_inline(int[] cols, int nowRowIndex) {
        int num = cols.length;
        if (nowRowIndex >= num) {
            return false;
        }
        if (nowRowIndex == 0) {
            return false;
        }
        boolean is_inline = false;
        for (int i = nowRowIndex - 1; i >= 0; i--) {
            if (is_inline(nowRowIndex, cols[nowRowIndex], i, cols[i])) {
                is_inline = true;
            }
        }
//        nowRowIndex += 1;
//        return is_inline(cols, nowRowIndex);
        return is_inline;
    }

    private void toString(int[] cols) {
        List<String> temp = new ArrayList<>();
        StringBuilder tempBuilder = new StringBuilder();
        for (int col : cols) {
            tempBuilder.delete(0, tempBuilder.length());
            for (int j = 0; j < cols.length; j++) {
                if (col == j) {
                    tempBuilder.append("Q");
                } else {
                    tempBuilder.append(".");
                }
            }
            temp.add(tempBuilder.toString());
        }
        result.add(temp);
    }
}
