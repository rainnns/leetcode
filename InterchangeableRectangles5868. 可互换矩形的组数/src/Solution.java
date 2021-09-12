import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/12 10:47
 */
public class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long res = 0;
        HashMap<Double, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            double p;
            if (rectangle[1] == 0) {
                p = -1;
            } else {
                p = (double) rectangle[0] / rectangle[1];
            }
            List<Integer> list = hashMap.get(p);
            if (list == null) {
                list = new ArrayList<>();
            } else {
                res += list.size();
            }
            list.add(i);
            hashMap.put(p, list);
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] rectangles =  new int[][]{{4,8},{3,6},{10,20},{15,30}};
        System.out.println(new Solution().interchangeableRectangles(rectangles));
    }

}
