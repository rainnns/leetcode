import java.util.HashSet;
import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/29 21:58
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] row1Splits = scanner.nextLine().split(" ");
        int n = Integer.parseInt(row1Splits[0]);
        int m = Integer.parseInt(row1Splits[1]);
        int[] arr = new int[n];
        String[] row2Splits = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(row2Splits[i]);
        }

        int[] dp = new int[n + 2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = n; i > 0; i--) {
            if (set.contains(arr[i - 1])) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = dp[i + 1] + 1;
            }
            set.add(arr[i - 1]);
        }
        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(scanner.nextLine());
            System.out.println(dp[t]);
        }
    }
}
