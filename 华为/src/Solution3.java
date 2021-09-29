import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/29 20:20
 */
public class Solution3 {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String numsStr = scanner.nextLine();
        int[] nums = new int[n];
        String[] splits = numsStr.split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(splits[i]);
        }
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max - min) * (j - i + 1) % mod;
            }
        }
        System.out.println(sum);
    }
}
