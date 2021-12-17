/**
 * @author wwx-sys
 * @time 2021-12-17-11:12
 * @description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class T53_2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int t = (l + r) >> 1;
            if (nums[t] > t){
                r = t - 1;
            }
            else {
                l = t + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println(new T53_2().missingNumber(nums));
    }
}
