import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/16 19:50
 */
public class WaterBucket {

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, 1}};

    public int water(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                res += getWater(i, j, matrix);
            }
        }
        return res;
    }

    public int getWater(int x, int y, int[][] matrix) {
        int waterNum = Integer.MAX_VALUE;
        for (int[] dir : dirs) {
            int xx =x + dir[0];
            int yy =y + dir[1];
            if (matrix[xx][yy] < waterNum) {
                waterNum = matrix[xx][yy];
            }
        }
        return waterNum;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            int n = Integer.parseInt(line1.split(" ")[0]);
            int m = Integer.parseInt(line1.split(" ")[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] splits = line.split(" ");
                for (int j = 0; j < splits.length; j++) {
                    matrix[i][j] = Integer.parseInt(splits[j]);
                }
            }
            WaterBucket waterBucket = new WaterBucket();
            System.out.println(waterBucket.water(matrix));
        }

    }

}


