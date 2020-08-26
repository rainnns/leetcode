import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author wwx-sys
 * @time 2020-08-26-15:20
 * @description
 */
public class Solution {

    /**
     * 暴力解法
     * 从左到右扫描数组， 从当前元素向左扫描并更新，从当前元素向右扫描并更新，
     * 时间复杂度：O(n^2)。数组中的每个元素都需要向左向右扫描。
     * 空间复杂度 O(1) 的额外空间。
     *
     */
    public int trap1(int []height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = max(max_right, height[j]);
            }
            ans += min(max_left, max_right) - height[i];        //当前位置的雨水量等于 Min(左侧最高，右侧最高) - 当前高度
        }
        return ans;
    }

    /**
     * 动态规划，先找出在左边向右看的最大数组，和 在右边向左看的最大数组,再遍历数组，找到每一个位置的雨滴数
     *
     */
    public int trap2(int []height){
        int ans = 0;
        int [] leftMax = new int[height.length];
        int [] rightMax = new int[height.length];
        int temp = 0;
        for (int i = 0; i < height.length; i++) {       //找出在左边向右看的最大数组
            temp = max(temp,height[i]);
            leftMax[i] = temp;
        }
        temp = 0;
        for (int j = height.length - 1; j > 0; j--) {   //在右边向左看的最大数组
            temp = max(temp,height[j]);
            rightMax[j] = temp;
        }
        for (int i = 1; i < height.length - 1; i++)  {
            ans += (min(leftMax[i],rightMax[i]) - height[i]);       //当前位置的雨水量等于 Min(左侧最高，右侧最高) - 当前高度
        }
        return ans;
    }


}
