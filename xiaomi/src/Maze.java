import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/8 19:51
 */
public class Maze {
    int out_x;
    int out_y;
    int n;
    int m;
    int steps;
    int start_x;
    int start_y;

    public void maze(int x, int y, int[][] matrix) {
        if (x == out_x && y == out_y) {
            return;
        }
        if (x > 0 && matrix[x - 1][y] == 0) {
            steps += 1;
            maze(x - 1, y, matrix);
            steps -= 1;
        }
        if (y > 0 && matrix[x][y - 1] == 0) {
            steps += 1;
            maze(x, y - 1, matrix);
            steps -= 1;
        }
        if (x < m - 1 && matrix[x + 1][y] == 0) {
            steps += 1;
            maze(x + 1, y, matrix);
            steps -= 1;
        }
        if (y < n - 1 && matrix[x][y + 1] == 0) {
            steps += 1;
            maze(x, y + 1, matrix);
            steps -= 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] matrix = new int[m][n];

            Maze maze = new Maze();
            maze.m = m;
            maze.n = n;
            for (int i = 0; i < m; i++) {
                String line = in.nextLine();
                for (int j = 0; j < n; j++) {
                    char c = line.charAt(j);
                    int value = 0;
                    if (c == '#') {
                        value = 1;
                    }
                    if (c == '@') {
                        maze.start_x = i;
                        maze.start_y = j;
                    }
                    if (c == '$') {
                        maze.out_x = i;
                        maze.out_y = j;
                    }
                    matrix[i][j] = value;
                }
            }
            maze.maze(maze.start_x, maze.start_y, matrix);
            int res = maze.steps;
            System.out.println(res);
        }
    }

}
