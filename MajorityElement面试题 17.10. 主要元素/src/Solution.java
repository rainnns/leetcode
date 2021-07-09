public class Solution {

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int alive = 0;
        int candidate = -1;
        for (int num : nums) {
            if (alive == 0){
                candidate = num;
            }
            if (num == candidate){
                alive += 1;
            }
            else {
                alive -=1;
            }
        }
        alive = 0;
        for (int num : nums) {
            if (num==candidate){
                alive ++;
            }
        }
        return alive > nums.length/2 ? candidate : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(new Solution().majorityElement(nums));
    }
}
