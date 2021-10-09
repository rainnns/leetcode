import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/9 20:42
 */
public class T2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().split(" ");
        int a = Integer.parseInt(line1[0]);
        int b = Integer.parseInt(line1[1]);
        int f = Integer.parseInt(line1[2]);
        int k = Integer.parseInt(line1[3]);
        boolean flag = true;
        int current = b;
        int count = 0;
        while (k > 0) {
            if (flag) {//表示0到a
                if (current < f) {
                    System.out.println("-1");
                    break;
                }
                if (b < a + (a - f)) {
                    count++;
                    current = b;
                } else {
                    current -= a;
                }
            } else {//标识a到0
                if (current < f) {
                    count++;
                    current = b;
                } else {
                    current -= a;
                }
            }
            flag = !flag;
            k--;
        }
        System.out.println(count);

    }

}
