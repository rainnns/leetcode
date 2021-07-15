import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/15 15:56
 */
public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int ret = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0){
                arr[i] = 1;
            }
            else {
                if (arr[i] > arr[i - 1]){
                    ret += 1;
                    arr[i] = arr[i - 1] + 1;
                }
            }
        }
        return ret;
    }

    //计数排序+贪心

    /**
     * 首先，我们用一个长为 n+1n+1n+1 的数组 cnt 统计 arr 中的元素个数（将值超过 n 的元素视作 n）。然后，从 1 到 n 遍历 cnt 数组，若 cnt[i]=0，则说明缺失元素 i，我们需要在后续找一个大于 i 的元素，将其变更为 i。我们可以用一个变量 miss 记录 cnt[i]=0的出现次数，当遇到 cnt[i]>0 时，则可以将多余的 cnt[i]−1 个元素减小，补充到之前缺失的元素上。
     *
     * 遍历 cnt 结束后，若此时 miss=0，则说明修改后的 arr 包含了 [1,n] 内的所有整数；否则，对于不同大小的缺失元素，我们总是优先填补较小的，因此剩余缺失元素必然是 [n−miss+1,n] 这一范围内的 miss 个数，因此答案为 n−miss。
     * @param arr
     * @return
     */

    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr) {
            ++cnt[Math.min(v, n)];
        }
        int miss = 0;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) {
                ++miss;
            } else {
                miss -= Math.min(cnt[i] - 1, miss); // miss 不会小于 0，故至多减去 miss 个元素
            }
        }
        return n - miss;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,1};
        System.out.println(new Solution().maximumElementAfterDecrementingAndRearranging(arr));
    }
}
