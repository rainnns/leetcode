import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int max = Arrays.stream(candies).max().getAsInt();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}

/*
 * 总结：
 * 求数组的最大值，Arrays.stream方法
 *
 */
