import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-09-29-16:19
 * @description 剑指 Offer 12. 矩阵中的路径
 */
public class T12 {

    //dfs + 剪枝
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i,j,0,word.toCharArray(),board)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, int currentIndex, char[] word, char[][] board) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[currentIndex]) {
            return false;
        }
        if (currentIndex == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(i + 1, j, currentIndex + 1, word, board) || dfs(i - 1, j, currentIndex + 1, word, board) || dfs(i, j + 1, currentIndex + 1, word, board) || dfs(i, j - 1, currentIndex + 1, word, board);
        board[i][j] = word[currentIndex];
        return res;
    }
}
