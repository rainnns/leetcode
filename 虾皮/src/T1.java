import java.util.Arrays;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/11 18:37
 */
public class T1 {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * <p>
     * <p>
     * 最大正整数
     *
     * @param arrs int整型一维数组 正整数数组
     * @return int整型
     */
    public int maxIntValue(int[] arrs) {
        // write code here
        Arrays.sort(arrs);
        int res = 0;
        for (int i = arrs.length - 1; i >= 0; i--) {
            res = res * 10 + arrs[i];
        }
        return res;
    }
}
