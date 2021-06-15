import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author wwx-sys
 * @time 2020-09-21-16:51
 * @description
 */
public class Solution {

    //动态规划 - 使用柱状图的优化暴力方法
    //时间复杂度 : O(N * N *M)
    //空间复杂度 : O(N *M)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] widths = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    count += 1;
                } else {
                    count = 0;
                }
                widths[i][j] = count;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int minWidth = widths[j][i];
                for (int k = j; k < matrix.length; k++) {
                    minWidth = min(minWidth, widths[k][i]);
                    int height = k - j + 1;
                    maxArea = max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }

    /**
     * 将题目理解为逐行求解最大柱形面积（见LargestRectangleArea84），从 0，0-1，0-2，……，0-n行，逐行增加来求解，每一列的高度通过维护一个数组dp
     * 时间复杂度 : O(N^2 M)。由于需要遍历同一列中的值，计算每个点对应最大面积需要O(N)。对全部N∗M个点都要计算，因此总共O(N)∗O(NM)=O(N^2 M)。
     *
     * 空间复杂度 : O(NM)。我们分配了一个等大的数组，用于存储每个点的最大宽度。
     *
     */
    public int maximalRectangle2(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];       //对于每一行作为底来说，是每一列的最大高度

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {

                // update the state of this row's histogram using the last row's histogram
                // by keeping track of the number of consecutive ones

                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            // update maxarea with the maximum area from this row's histogram
            maxarea = Math.max(maxarea, leetcode84(dp));
        } return maxarea;
    }

    public int leetcode84(int[] heights) {
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
