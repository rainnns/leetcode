import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/13 15:47
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Map.Entry<Integer, Integer>> cords = new ArrayList<>();
        //先遍历一边，找到待添加点
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            //用负的高程标识左端点
            cords.add(new AbstractMap.SimpleEntry<>(left, -height));
            //用正的高程标识右端点
            cords.add(new AbstractMap.SimpleEntry<>(right, height));
        }
        //排序
        cords.sort((o1, o2) -> !o1.getKey().equals(o2.getKey()) ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue());
        //保存当前位置所有高度
        List<Integer> heights = new ArrayList<>();
        heights.add(0);
        //保存上一个位置的横坐标以及高度
        Integer[] last = new Integer[]{0, 0};

        for (Map.Entry<Integer, Integer> pair : cords) {
            int x = pair.getKey();
            int height = pair.getValue();
            if (height < 0) {
                //左端点，高度入栈
                heights.add(-height);
            } else {
                //右端点，移除高度
                heights.remove((Integer) height);
            }
            heights.sort(Collections.reverseOrder());
            //当前最大高度
            int maxHeight = heights.get(0);
            //如果当前高度不等于上一个高度，说明这是一个转折点
            if (last[1] != maxHeight) {
                // 更新 last，并加入结果集
                last[0] = x;
                last[1] = maxHeight;
                ret.add(new ArrayList<>(Arrays.asList(last)));
            }

        }
        return ret;
    }

    public List<List<Integer>> getSkyline2(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings) {
            pq.offer(new int[] { building[0], -building[2] });
            pq.offer(new int[] { building[1], building[2] });
        }

        List<List<Integer>> res = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>((a, b) -> b - a);
        heights.put(0, 1);
        int left = 0, height = 0;
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[1] < 0) {
                heights.put(-arr[1], heights.getOrDefault(-arr[1], 0) + 1);
            } else {
                heights.put(arr[1], heights.get(arr[1]) - 1);
                if (heights.get(arr[1]) == 0) heights.remove(arr[1]);
            }
            int maxHeight = heights.keySet().iterator().next();
            if (maxHeight != height) {
                left = arr[0];
                height = maxHeight;
                res.add(Arrays.asList(left, height));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//        int[][] buildings = {{0, 2, 3}, {2, 5, 3}};
        System.out.println(new Solution().getSkyline2(buildings));
    }
}
