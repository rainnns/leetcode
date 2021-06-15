import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2020-12-11-10:01
 * @description
 */
//耗时1小时，终是没有思路，遂放弃
public class Solution {
    public boolean ListTargetSum(int[]arr, int sum){
        if (arr.length < 1 || sum < 0){return false;}
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < sum){
                sums.add(arr[i]);
            }
            else if (arr[i] == sum){
                return true;
            }
        }
        while (sums.size() > 0){
//            sums.forEach();
        }

        return false;
    }
}
