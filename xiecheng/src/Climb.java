import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/16 19:06
 */
public class Climb {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int res = Integer.MAX_VALUE;
    public void cost(int x, int y, Map<Integer, List<int[]>> listMap, int[][] matrix, int cost) {
        if (x == matrix.length - 1 && y == matrix[0].length - 1) {
            res = Math.min(res, cost);
            return;
        }
        int height = matrix[x][y];
        matrix[x][y] = -1;
        List<int[]> sameHeights = listMap.get(height);
        for (int[] sameHeight : sameHeights) {
            int _x = sameHeight[0];
            int _y = sameHeight[1];
            if ((_x != x || _y != y) && matrix[_x][_y] != -1) {
                cost(_x, _y, listMap, matrix, cost);
            }
        }
        for (int[] dir : dirs) {
            int xx = x + dir[0];
            int yy = y + dir[1];
            if (xx >= 0 && xx <= matrix.length - 1 && yy >= 0 && yy <= matrix[0].length - 1 && matrix[xx][yy] != -1) {
                int dif = Math.abs(height - matrix[xx][yy]);
                cost(xx, yy, listMap, matrix, cost + dif);
            }
        }
        matrix[x][y] = height;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            int n = Integer.parseInt(line1.split(" ")[0]);
            int m = Integer.parseInt(line1.split(" ")[1]);
            int[][] matrix = new int[n][m];
            Map<Integer, List<int[]>> listMap = new HashMap<>();

            for (int i = 0; i < m; i++) {
                String line = scanner.nextLine();
                String[] splits = line.split(" ");
                for (int j = 0; j < splits.length; j++) {
                    matrix[i][j] = Integer.parseInt(splits[j]);
                    List<int[]> sameHeights = listMap.getOrDefault(matrix[i][j], new ArrayList<>());
                    sameHeights.add(new int[]{i, j});
                    listMap.put(matrix[i][j], sameHeights);
                }
            }
            Climb climb = new Climb();
            climb.cost(0, 0, listMap, matrix, 0);
            System.out.println(climb.res);
        }
    }
}
