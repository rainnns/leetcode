import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/8/8 11:46
 */
public class Solution {

    //栈+二分
    //
    //思路：
    //每遍历一个数的时候，如果
    //1.当前数大于或等于栈顶数，则直接入栈
    //2.当前数小于栈顶数，则用二分查找栈内第一个比当前数大的数，进行替换。
    //
    //这样栈的总长度不变，但是中间的数由于替换变得更小了，也就是说整个栈更优了，将来有机会更新到更长的序列
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        //最长上升子序列
        int[] stack = new int[n];//恒定的
        int top = -1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (top == -1 || obstacles[i] >= stack[top]) {
                stack[++top] = obstacles[i];
                res[i] = top + 1;
            } else {
                //二分
                int l = 0, r = top, m;
                while (l < r) {
                    m = l + (r - l) / 2;
                    if (stack[m] <= obstacles[i]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                stack[r] = obstacles[i];
                res[i] = r + 1;
            }
        }
        return res;
    }

    //超时
    public int[] longestObstacleCourseAtEachPosition1(int[] obstacles) {
        int n = obstacles.length;
        int[] res = new int[n];
        int[] counts = new int[1000001];
        res[0] = 1;
        counts[obstacles[0]] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = 1;
            int max = 0;
            for (int j = 1; j <= obstacles[i]; j++) {
                if (max < counts[j]) {
                    max = counts[j];
                }
            }
            res[i] += max;
            counts[obstacles[i]] = res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] obstacles = new int[]{5, 2, 5, 4, 4, 4, 1, 1, 1, 5, 3, 1};
        System.out.println(Arrays.toString(new Solution().longestObstacleCourseAtEachPosition(obstacles)));
    }
}
