/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/6 12:34
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0 ,r = nums.length -1;
        while(l <= r){
            int index = (l + r) >> 1;
            int t = nums[index];
            if(t <target){
                l++;
            }
            else if ( t > target){
                r--;
            }
            else{
                return index;
            }
        }
        return -1;
    }
}
