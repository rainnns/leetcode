import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wwx-sys
 * @time 2020-09-04-19:49
 * @description
 */
class Solution {

    /**
     * 维护一个单调递增栈，遇到比栈顶低的方块出栈，计算当前面积.
     * 右边界为i,左边界为 栈顶元素（当栈为空时，左边界为 -1），宽为 右边界 - 左边界 - 1 , 高为 height[出栈元素]，
     * 数组遍历完成后，栈中元素依次出栈，右边界为heights.length, 左边界为栈顶元素（当栈为空时，左边界为 -1）,宽为 右边界 - 左边界 - 1 , 高为 height[出栈元素]，
     * 时间复杂度:O(N),输入数组里的每一个元素入栈一次，出栈一次。
     * 空间复杂度：O(N)，栈的空间最多为 N
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty()) {
                if (heights[i] < heights[stack.peek()]) {
                    while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                        int current = stack.pop();
                        int left = -1;
                        if (!stack.isEmpty()) {
                            left = stack.peek();
                        }
                        int width = i - left - 1;
                        maxArea = Math.max(maxArea, width * heights[current]);
                    }
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int current = stack.pop();
            int left = -1;
            if (!stack.isEmpty()) {
                left = stack.peek();
            }
            int width = heights.length - left - 1;
            maxArea = Math.max(maxArea, width * heights[current]);
        }

        return maxArea;
    }

}
