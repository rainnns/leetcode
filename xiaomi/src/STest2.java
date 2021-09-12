import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/8 18:56
 */
public class STest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int res = n;
            while(m > 0){
                res += Math.sqrt(n);
                m --;
            }
            System.out.println(res);
        }
    }
}
