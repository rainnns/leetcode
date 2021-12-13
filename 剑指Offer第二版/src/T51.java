/**
 * @author wwx-sys
 * @time 2021-12-13-15:21
 * @description 剑指 Offer 51. 数组中的逆序对
 */
public class T51 {

    int[] nums, tmp;

    //归并排序
    public int reversePairs(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    public int mergeSort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = (l + r) >> 1;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        //合并
        int i = l, j = m + 1;
        System.arraycopy(nums, l, tmp, l, r + 1 - l);
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = tmp[j++];
            } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                res += m - i + 1;
            }
        }
        return res;

    }

}
