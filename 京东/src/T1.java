import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/9 19:53
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);
        int d = Integer.parseInt(line1[2]);
        String[] line2 = scanner.nextLine().split(" ");
        List<Integer> order = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            order.add(i);
        }
        order.sort(Comparator.comparingInt(o -> Integer.parseInt(line2[o - 1])));
        String[] line3 = scanner.nextLine().split(" ");
        String[] line4 = scanner.nextLine().split(" ");
        int maxLove = -1;
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(line3[i]) <= k && Integer.parseInt(line4[i]) <= d / n * order.get(i) && Integer.parseInt(line2[i]) > maxLove) {
                maxLove = Integer.parseInt(line2[i]);
            }
        }
        System.out.println(maxLove);
    }
}
