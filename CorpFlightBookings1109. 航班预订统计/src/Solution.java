import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-08-31-15:06
 * @description
 */
public class Solution {

    //差分
    //差分数组对应的概念是前缀和数组，对于数组 [1,2,2,4]，其差分数组为 [1,1,0,2]，差分数组的第 i 个数即为原数组的第 i−1 个元素和第 i 个元素的差值，也就是说我们对差分数组求前缀和即可得到原数组
    //差分数组的性质是，当我们希望对原数组的某一个区间 [l,r] 施加一个增量inc 时，差分数组 d 对应的改变是：d[l] 增加 inc，d[r+1] 减少 inc。这样对于区间的修改就变为了对于两个位置的修改。并且这种修改是可以叠加的，即当我们多次对原数组的不同区间施加不同的增量，我们只要按规则修改差分数组即可。
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
           res[booking[0] - 1] += booking[2];
           if (booking[1] < n){
               res[booking[1]] -= booking[2];
           }
        }
        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }


    //暴力
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int seats = booking[2];
            for (int i = start - 1; i < end; i++) {
                res[i] += seats;
            }
        }
        return res;
    }



}
