import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/29 10:51
 */
public class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                for (int i = 0; i < o1.length(); i++) {
                    if (o2.charAt(i) != o1.charAt(i)) {
                        return o2.charAt(i) - o1.charAt(i);
                    }
                }
                return 0;
            }
        });
        return nums[k - 1];
    }

    public static void main(String[] args) {
        String[] nums = new String[]{"2", "21", "12", "1"};
        System.out.println(new Solution().kthLargestNumber(nums, 3));
    }
}
