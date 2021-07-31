import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @author wwx-sys
 * @time 2021-07-31-9:48
 * @description
 */
public class Solution {
    List[] lists = new List[2001];

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverseTreeNode(root, 0, 0);
        for (List list : lists) {
            if (list == null) continue;
            list.sort((Comparator<int[]>) (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return o1[0] > o2[0] ? 1 : -1;
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<int[]> list : lists) {
            if (list == null) continue;
            List<Integer> temp = new ArrayList<>();
            for (int[] o : list) {
                temp.add(o[1]);
            }
            res.add(temp);
        }

        return res;
    }

    public void traverseTreeNode(TreeNode parent, int y, int x) {
        if (parent == null) {
            return;
        }
        if (lists[y + 1000] == null) {
            lists[y + 1000] = new ArrayList<>();
        }
        lists[y + 1000].add(new int[]{x, parent.val});
        traverseTreeNode(parent.left, y - 1, x + 1);
        traverseTreeNode(parent.right, y + 1, x + 1);
    }

    public List<List<Integer>> verticalTraversal1(TreeNode root) {
        List<int[]> nodes = new ArrayList<int[]>();
        dfs(root, 0, 0, nodes);
        nodes.sort(new Comparator<int[]>() {
            public int compare(int[] tuple1, int[] tuple2) {
                if (tuple1[0] != tuple2[0]) {
                    return tuple1[0] - tuple2[0];
                } else if (tuple1[1] != tuple2[1]) {
                    return tuple1[1] - tuple2[1];
                } else {
                    return tuple1[2] - tuple2[2];
                }
            }
        });
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int size = 0;
        int lastcol = Integer.MIN_VALUE;
        for (int[] tuple : nodes) {
            int col = tuple[0], row = tuple[1], value = tuple[2];
            if (col != lastcol) {
                lastcol = col;
                ans.add(new ArrayList<Integer>());
                size++;
            }
            ans.get(size - 1).add(value);
        }
        return ans;
    }

    public void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(0), new TreeNode(2)), new TreeNode(4, new TreeNode(2), null));
        System.out.println(new Solution().verticalTraversal(root));
    }
}
