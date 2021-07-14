import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/14 14:51
 */
public class Solution {
    /**
     * 绝对差值和
     * 排序+ 二分查找
     「找到 nums1 中最接近 nums2[i] 的值」，这个值可能在二分查找过程中的 mid-1/mid/mid+1 中出现，为了不侵入二分查找，可以转化为「找到 nums1 中大于等于 nums2[i] 的最小下标 j」，那么该值可能在 j（j < n） 或 j-1（j > 0）
     遍历过程中使用了取模操作，可能会导致最终 sum < maxn，因此结果要使用 (sum - maxn + mod) % mod 的形式
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        //用 maxn 记录最大的改变前后的差值
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,7,5};
        int[] nums2 = new int[]{2,3,5};
        System.out.println(new Solution().minAbsoluteSumDiff(nums1,nums2));
    }
}
