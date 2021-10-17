import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/17 10:18
 */
public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] a = scanner.nextLine().split(" ");
        String[] b = scanner.nextLine().split(" ");
        int mod = 1000000007;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(a[i - 1]);
            int index = Integer.parseInt(b[i -1]) - 1;
            dp[i] = num * dp[index] % mod;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i]);
        }
    }
}
