import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-12-31-10:13
 * @description 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class T57_2 {

    //求和公式
    public int[][] findContinuousSequence1(int target) {
        int num = 2;
        int a1 = target;
        LinkedList<int[]> list = new LinkedList<>();
        while (a1 >= 1) {
            int dif = target - num * (num - 1) / 2;
            int mod = dif % num;
            a1 = dif / num;
            if (mod == 0 && a1 > 0) {
                int[] t = new int[num];
                for (int i = 0; i < num; i++) {
                    t[i] = a1++;
                }
                list.addFirst(t);
            }
            num++;
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    //滑动窗口（双指针）
    // 左窗口边界 i, 右窗口边界 j ,当 窗口内和小于 target 时 ， j ++ ，当 和 大于等于 target  的 时候 i ++;
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, s = 3;
        LinkedList<int[]> list = new LinkedList<>();
        while (i < j) {
            if (s == target) {
                int[] t = new int[j - i + 1];
                for (int k = 0; k < t.length; k++) {
                    t[k] = i + k;
                }
                list.addLast(t);
            }
            if (s < target) {
                j++;
                s += j;
                continue;
            }
            s -= i;
            i++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T57_2().findContinuousSequence(9)));
    }
}
