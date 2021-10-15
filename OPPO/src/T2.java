/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/15 10:06
 */
public class T2 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 按传输的文件数量和个数限制，计算出有多少种选择方式
     *
     * @param data int整型二维数组 * 其中第一个数组包含三个整数 n，k，m（1≤n≤2e5,0≤k≤1e9,1≤m≤n) ，其中第二个数组按创建天数给出每天的文件数a(0≤a≤1e9)
     * @return int整型
     */
    public int dpAlg(int[][] data) {
        // write code here
        int n = data[0][0];
        int k = data[0][1];
        int m = data[0][2];

        int res0 = 0;
        for (int i = 0; i < m; i++) {
            res0 += data[1][i];
        }
        int count = res0 <= k ? 1 : 0;
        for (int i = m; i < n; i++) {
            res0 += data[1][i] - data[1][i - m];
            if (res0 <= k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{ {3,100,2},{1,2,3} };
        System.out.println(new T2().dpAlg(data));
    }
}
