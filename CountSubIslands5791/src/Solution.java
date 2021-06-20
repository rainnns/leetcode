import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/20 11:13
 */

public class Solution {
    private int m;
    private int n;
    //未通过，仅通过10/61的测试用例
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        this.m = grid1.length;
        this.n = grid1[0].length;
        List<List<Map.Entry<Integer, Integer>>> islands = new ArrayList<>();
        int[][] flags = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && flags[i][j] == 0) {
                    List<Map.Entry<Integer, Integer>> island = new ArrayList<>();
                    island.add(new AbstractMap.SimpleEntry<>(i, j));
                    flags[i][j] = 1;
                    findWholeIsland(i, j, grid2, flags, island);
                    islands.add(island);
                }
            }
        }
        for (List<Map.Entry<Integer, Integer>> island : islands) {
            boolean isContained = true;
            for (Map.Entry<Integer, Integer> cords : island) {
                int i = cords.getKey();
                int j = cords.getValue();
                if (grid1[i][j] != 1) {
                    isContained = false;
                    break;
                }
            }
            if (isContained) {
                count += 1;
            }
        }


        return count;
    }

    public void findWholeIsland(int i, int j, final int[][] grid, int[][] flags, List<Map.Entry<Integer, Integer>> island) {
        //下
        if (i + 1 < m && grid[i + 1][j] == 1 && flags[i + 1][j] == 0) {
            island.add(new AbstractMap.SimpleEntry<>(i + 1, j));
            flags[i + 1][j] = 1;
            findWholeIsland(i + 1, j, grid, flags, island);
        }
        //上
        if (i - 1 > 0 && grid[i - 1][j] == 1 && flags[i - 1][j] == 0) {
            island.add(new AbstractMap.SimpleEntry<>(i - 1, j));
            flags[i - 1][j] = 1;
            findWholeIsland(i - 1, j, grid, flags, island);
        }
        //左
        if (j - 1 > 0 && grid[i][j - 1] == 1 && flags[i][j - 1] == 0) {
            island.add(new AbstractMap.SimpleEntry<>(i, j - 1));
            flags[i][j - 1] = 1;
            findWholeIsland(i, j - 1, grid, flags, island);
        }
        //右
        if (j + 1 < n && grid[i][j + 1] == 1 && flags[i][j + 1] == 0) {
            island.add(new AbstractMap.SimpleEntry<>(i, j + 1));
            flags[i][j + 1] = 1;
            findWholeIsland(i, j + 1, grid, flags, island);
        }
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,1,1,0,0}, {0,1,1,1,1}, {0, 0, 0, 0, 0}, {1,0,0,0,0}, {1,1,0,1,1}};
        int[][] grid2 = new int[][]{{1,1,1,0,0}, {0,0,1,1,1}, {0,1,0,0,0}, {1,0,1,1,0}, {0,1,0,1,0}};

        System.out.println(new Solution().countSubIslands(grid1,grid2));
    }

}
