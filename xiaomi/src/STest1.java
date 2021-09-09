import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/8 16:38
 */
public class STest1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] arr = new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            int res = number(arr);
            System.out.println(res);
        }
    }

    private static int number(int[][] arr) {
        List<Integer> friends = new ArrayList<>();
        HashSet<Integer> newFriends = new HashSet<>();
        newFriends.add(1);
        friends.add(1);
        while (!newFriends.isEmpty()) {
            List<Integer> temp = new ArrayList<>(newFriends);
            newFriends.clear();
            for (int[] a : arr) {
                if (a[2] == 0) {
                    continue;
                }
                if (temp.contains(a[0]) && !friends.contains(a[1])) {
                    newFriends.add(a[1]);
                    friends.add(a[1]);
                }
                if (temp.contains(a[1]) && !friends.contains(a[0])) {
                    newFriends.add(a[0]);
                    friends.add(a[0]);
                }
            }
        }
        return friends.size() - 1;
    }
}
