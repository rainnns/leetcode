import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/4 19:06
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] n = new int[10001];
        for (int num : nums) {
            n[num] += 1;
            if (n[num] != 1){
                res[0] = num;
            }
        }
        for (int i = 1; i < 10001 ; i++) {
            if (n[i] == 0){
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,4,6,5};
        System.out.println(Arrays.toString(new Solution().findErrorNums(nums)));
    }
}
