import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/8 19:14
 */
public class Card {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int[] nums = new int[100];
            int cur = -1;
            while (4 * N > 100) {

                cur = (cur + 4 * N) % 100;
                while (nums[cur] == 1) {
                    cur = (cur + 1) % 100;
                }
                nums[cur] = 1;
                N--;
            }
            System.out.println(cur + 1);
        }
    }
}
