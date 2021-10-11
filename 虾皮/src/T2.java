import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/11 19:36
 */
public class T2 {
    int[] preOrder;
    Map<Integer, Integer> midOrder = new HashMap<>();
    Map<Integer, List<Integer>> treeFloor = new HashMap<>();

    public int[] levelPrintTree(int[] pre, int[] mid) {
        // write code here
        if (pre.length == 0) {
            return new int[0];
        }

        preOrder = pre;
        for (int i = 0; i < mid.length; i++) {
            midOrder.put(mid[i], i);
        }
        recur(0, 0, mid.length - 1, 0);
        int[] res = new int[pre.length];
        int depth = 0;
        int last = 0;
        while (treeFloor.get(depth) != null) {
            for (Integer i : treeFloor.get(depth++)) {
                res[last++] = i;
            }
        }
        return res;
    }

    public void recur(int rootIndexInPre, int leftInMid, int rightInMid, int depth) {
        if (leftInMid > rightInMid) {
            return;
        }
        List<Integer> list = treeFloor.get(depth);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(preOrder[rootIndexInPre]);
        treeFloor.put(depth, list);
        int rootIndexInMid = midOrder.get(preOrder[rootIndexInPre]);
        recur(rootIndexInPre + 1, leftInMid, rootIndexInMid - 1, depth + 1);
        recur(rootIndexInPre + rootIndexInMid - leftInMid + 1, rootIndexInMid + 1, rightInMid, depth + 1);
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 3, 4, 5, 2};
        int[] mid = new int[]{4, 3, 5, 1, 2};

        System.out.println(Arrays.toString(new T2().levelPrintTree(pre, mid)));
    }


}
