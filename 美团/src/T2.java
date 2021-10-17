import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/17 11:14
 */
public class T2 {
    static int count;

    public static void recur(int i, List<Integer> list, int n, int[] vis) {
        if (i == n) {
            count++;
            System.out.println(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (vis[j] == 0 && j != i) {
                vis[j] = 1;
                list.add(j + 1);
                recur(i + 1, list, n, vis);
                list.remove((Integer) j );
                vis[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        recur(0, list, n, new int[n]);
    }


}
