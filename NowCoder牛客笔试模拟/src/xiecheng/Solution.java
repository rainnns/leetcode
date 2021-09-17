package xiecheng;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author wwx-sys
 * @time 2021-09-16-17:01
 * @description
 */
public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        List<int[]> source = new ArrayList<>();
        source.add(new int[]{0, 30});
        source.add(new int[]{0, 60});
        source.add(new int[]{20, 60});
        source.add(new int[]{60, 70});
        source.add(new int[]{60, 70});
//        while (in.hasNextLine() && n > 1) {
//            String line = in.nextLine();
//            int start = Integer.parseInt(line.split(",")[0]);
//            int end = Integer.parseInt(line.split(",")[1]);
        for (int[] ints : source) {
            int start = ints[0];
            int end = ints[1];
            if (!queue.isEmpty() && queue.peek() <= start) {
                queue.poll();
            }
            queue.add(end);

        }
        //            n--;
//            queue.add(end);
//            if (queue.isEmpty() || queue.peek() <= start) {
//                queue.poll();
//            }
//            n--;
//        }
        System.out.println(queue.size());

    }
}
