import java.util.Stack;

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
     */
    public int trap1(int[] height) {
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
     * 时间复杂度：O(n)。
     * 存储最大高度数组，需要两次遍历，每次 O(n)。
     * 最终使用存储的数据更新ans，O(n)。
     * 空间复杂度 O(n) 的额外空间。
     * 和方法 1 相比使用了额外的 O(n) 空间用来放置 left_max 和 right_max 数组。
     */
    public int trap2(int[] height) {
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int temp = 0;
        for (int i = 0; i < height.length; i++) {       //找出在左边向右看的最大数组
            temp = max(temp, height[i]);
            leftMax[i] = temp;
        }
        temp = 0;
        for (int j = height.length - 1; j > 0; j--) {   //在右边向左看的最大数组
            temp = max(temp, height[j]);
            rightMax[j] = temp;
        }
        for (int i = 1; i < height.length - 1; i++) {
            ans += (min(leftMax[i], rightMax[i]) - height[i]);       //当前位置的雨水量等于 Min(左侧最高，右侧最高) - 当前高度
        }
        return ans;
    }

    /**
     * 通过维护一个单调递减栈，来看可能形成低洼的柱子，当遇到比栈顶高的柱子，不断弹出栈顶并求值，直到栈顶元素比当前柱子低，然后当前柱子入栈，作为新的栈顶
     * 栈顶的条形块被当前的条形块和栈的前一个条形块界定
     * 时间复杂度：O(n)。
     * 单次遍历 O(n) ，每个条形块最多访问两次（由于栈的弹入和弹出），并且弹入和弹出栈都是 O(1)的。
     * 空间复杂度 O(n) 栈最多在阶梯型或平坦型条形块结构中占用 O(n)的空间。
     */
    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int width = i - stack.peek() - 1;
                int bounded_height = min(height[i], height[stack.peek()]) - height[top];
                ans += width * bounded_height;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 使用双指针,和方法 2 相比，我们不从左和从右分开计算，我们想办法一次完成遍历。
     * 所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
     * 我们必须在遍历时维护 left_max 和 right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
     * 时间复杂度：O(n)。单次遍历的时间O(n)。
     * 空间复杂度：O(1)的额外空间。left, right, left_max 和 right_max 只需要常数的空间
     */
    public int trap4(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left <= right){
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += (leftMax - height[left]);
                }
                left ++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += (rightMax - height[right]);
                }
                right --;
            }
        }
        return ans;
    }


}
