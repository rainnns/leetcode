import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/26 12:19
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int n = people.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            res++;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] people = new int[]{3,2,2,1};
        int limit = 3;
        System.out.println(new Solution().numRescueBoats(people, limit));
    }

}
