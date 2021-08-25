import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-08-25-14:39
 * @description
 */
public class Solution {
    int n;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        paths.add(0);
        dfs(0,graph,paths);
        return res;
    }

    public void dfs(int start, int[][] graph, List<Integer> paths) {
        if (start == n - 1) {
            res.add(new ArrayList<>(paths));
            return;
        }
        for (int i : graph[start]) {
            paths.add(i);
            dfs(i, graph, paths);
            paths.remove(paths.size() -1);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(new Solution().allPathsSourceTarget(graph));
    }

}
