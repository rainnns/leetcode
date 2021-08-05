import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wwx-sys
 * @time 2021-08-05-15:35
 * @description
 */
public class Solution {

    //方法一：深度优先搜索 + 三色标记法
    //根据题意，若起始节点位于一个环内，或者能到达一个环，则该节点不是安全的。否则，该节点是安全的。
    //
    //我们可以使用深度优先搜索来找环，并在深度优先搜索时，用三种颜色对节点进行标记，标记的规则如下：
    //    白色（用 0 表示）：该节点尚未被访问；
    //    灰色（用 1 表示）：该节点位于递归栈中，或者在某个环上；
    //    黑色（用 2 表示）：该节点搜索完毕，是一个安全节点。
    //
    //当我们首次访问一个节点时，将其标记为灰色，并继续搜索与其相连的节点。
    //
    //如果在搜索过程中遇到了一个灰色节点，则说明找到了一个环，此时退出搜索，栈中的节点仍保持为灰色，这一做法可以将「找到了环」这一信息传递到栈中的所有节点上。
    //
    //如果搜索过程中没有遇到灰色节点，则说明没有遇到环，那么递归返回前，我们将其标记由灰色改为黑色，即表示它是一个安全的节点。
    //时间复杂度：O(n+m)，其中 n 是图中的点数，m 是图中的边数。
    //
    //空间复杂度：O(n)。存储节点颜色以及递归栈的开销均为 O(n)。
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }

    //方法二：拓扑排序
    //
    //根据题意，若一个节点没有出边，则该节点是安全的；若一个节点出边相连的点都是安全的，则该节点也是安全的。
    //
    //根据这一性质，我们可以将图中所有边反向，得到一个反图，然后在反图上运行拓扑排序。
    //
    //具体来说，首先得到反图 rg 及其入度数组 inDeg。将所有入度为 0 的点加入队列，然后不断取出队首元素，将其出边相连的点的入度减一，若该点入度减一后为 0，则将该点加入队列，如此循环直至队列为空。
    // 循环结束后，所有入度为 0 的节点均为安全的。我们遍历入度数组，并将入度为 0 的点加入答案列表。
    //时间复杂度：O(n+m)，其中 n 是图中的点数，m 是图中的边数。
    //
    //空间复杂度：O(n+m)。需要 O(n+m) 的空间记录反图。
    //
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<Integer>());
        }
        int[] inDeg = new int[n];
        for (int x = 0; x < n; ++x) {
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            inDeg[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int y = queue.poll();
            for (int x : rg.get(y)) {
                if (--inDeg[x] == 0) {
                    queue.offer(x);
                }
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }


    //单纯递归也做不了，会有死循环的情况
    private int[] flags;

    public List<Integer> eventualSafeNodesLL(int[][] graph) {
        int n = graph.length;
        flags = new int[n];
        List<Integer> factors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            isElementSafe(i, graph);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (flags[i] == 1) {
                factors.add(i);
            }
        }
        return factors;
    }

    public void isElementSafe(int i, int[][] graph) {
        if (flags[i] == 0) {
            for (int t : graph[i]) {
                if (flags[t] == 0) {
                    isElementSafe(t, graph);
                }
                if (flags[t] == -1) {
                    flags[i] = -1;
                    return;
                }
            }
            flags[i] = 1;
        }
    }


    //超出时间限制
    public List<Integer> eventualSafeNodesL(int[][] graph) {
        int n = graph.length;
        List<Integer> factors = new ArrayList<>();
        while (true) {
            int factorsN = factors.size();
            for (int i = 0; i < n; i++) {
                if (factors.contains(i)) {
                    continue;
                }
                boolean isSafe = true;
                for (int t : graph[i]) {
                    if (!factors.contains(t)) {
                        isSafe = false;
                        break;
                    }
                }
                if (isSafe) {
                    factors.add(i);
                }
            }
            if (factors.size() == factorsN) {
                break;
            }
        }
        factors.sort(Comparator.comparingInt(o -> o));
        return factors;
    }

    //通过反图，自己写一遍拓扑排序
    public List<Integer> eventualSafeNodesL2(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        //进行反图的构建
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            for (int t : graph[i]) {
                reverseGraph.get(t).add(i);
            }
            inDeg[i] = graph[i].length;
        }

        //先找到出度为0的点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int temp = queue.poll();
            for (Integer integer : reverseGraph.get(temp)) {
                if (--inDeg[integer] == 0){
                    queue.offer(integer);
                }
            }
        }
        List<Integer> factors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0){
                factors.add(i);
            }
        }

        return factors;
    }


    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
//        int[][] graph = new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println(new Solution().eventualSafeNodesL2(graph));
    }
}
