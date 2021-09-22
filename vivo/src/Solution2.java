/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/22 15:38
 */
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型 未来空闲工作日
     * @return int整型
     */
    public int workSchedule (int n) {
        // write code here
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;


        return dp[n];



    }
}
