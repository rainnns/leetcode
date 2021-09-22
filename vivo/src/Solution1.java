
import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/22 15:08
 */
public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算满足条件：”确保avg_cost <= K，同时能给平台吸引到最多的新用户“ 的用户集合。
     * 返回列表格式，按用户id升序排序
     *
     * @param userIdList     int整型一维数组 用户id列表
     * @param costList       double浮点型一维数组 用户的成本列表，和用户id列表一一对应
     * @param conversionList double浮点型一维数组 用户转化概率列表，和用户id列表一一对应
     * @param avg_cost       double浮点型 约束的最高期望推广成本
     * @return int整型一维数组
     */
    public int[] calculateUserList(int[] userIdList, double[] costList, double[] conversionList, double avg_cost) {
        // write code here
        List<double[]> list = new ArrayList<>();
        int n = userIdList.length;
        for (int i = 0; i < n; i++) {
            if (conversionList[i] == 0) {
                list.add(new double[]{i, Double.MAX_VALUE});
            } else {
                list.add(new double[]{i, costList[i] / conversionList[i]});
            }
        }
        list.sort((o1, o2) -> (int) (o1[1] - o2[1]));
        List<Integer> res = new ArrayList<>();
        double s_cost = 0;
        double s_conversion = 0;
        for (double[] doubles : list) {
            s_cost += costList[(int) doubles[0]];
            s_conversion += conversionList[(int) doubles[0]];
            if (s_cost / s_conversion > avg_cost) {
                break;
            }
            res.add((int) doubles[0] + 1);
        }
        res.sort(Comparator.comparingInt(o -> o));
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] userIdList = new int[]{1, 2, 3, 4, 5};
        double[] costList = new double[]{2.0, 3.0, 1.0, 3.0, 2.0};
        double[] conversionList = new double[]{0.2, 0.1, 0.2, 0.1, 0.4};
        System.out.println(Arrays.toString(new Solution1().calculateUserList(userIdList, costList, conversionList, 9.5)));

    }
}
