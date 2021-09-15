/**
 * @author wwx-sys
 * @time 2021-09-15-20:23
 * @description 迭代爬坡
 */

//我们首先在 [0,n) 的范围内随机一个初始位置 i，随后根据 nums[i−1],nums[i],nums[i+1] 三者的关系决定向哪个方向走：
//
//    如果 nums[i−1]<nums[i]>nums[i+1]，那么位置 i 就是峰值位置，我们可以直接返回 i 作为答案；
//
//    如果 nums[i−1]<nums[i]<nums[i+1]，那么位置 i 处于上坡，我们需要往右走，即 i←i+1；
//
//    如果 nums[i−1]>nums[i]>nums[i+1]，那么位置 i 处于下坡，我们需要往左走，即 i←i−1；
//
//    如果 nums[i−1]>nums[i]<nums[i+1]，那么位置 i 位于山谷，两侧都是上坡，我们可以朝任意方向走。

//如果我们规定对于最后一种情况往右走，那么当位置 i 不是峰值位置时：
//
//    如果 nums[i]<nums[i+1]，那么我们往右走；
//
//    如果 nums[i]>nums[i+1]，那么我们往左走。

//我们知道位置 i+1i+1i+1 以及其右侧的位置中一定有一个峰值，因此我们可以设计出如下的一个算法：
//
//    对于当前可行的下标范围 [l,r]，我们固定选取i作为[l,r]的中点；
//
//    如果下标 i 是峰值，我们返回 i 作为答案；
//
//    如果 nums[i]<nums[i+1]，那么我们抛弃 [l,i] 的范围，在剩余 [i+1,r] 的范围内继续随机选取下标；
//
//    如果 nums[i]>nums[i+1]，那么我们抛弃 [i,r]的范围，在剩余 [l,i−1] 的范围内继续随机选取下标。
//


public class Solution2 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,3,4,5,7};
        System.out.println(new Solution2().findPeakElement(nums));
    }


}
