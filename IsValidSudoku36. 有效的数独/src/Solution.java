/**
 * @author wwx-sys
 * @time 2021-09-17-16:09
 * @description
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rows[i][c - '1']++;
                    columns[j][c - '1']++;
                    subBoxes[i / 3][j / 3][c - '1']++;
                    if (rows[i][c - '1'] > 1 || columns[j][c - '1'] > 1 || subBoxes[i / 3][j / 3][c - '1'] > 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

}
