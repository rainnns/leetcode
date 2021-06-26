import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/25 16:22
 */
public class Solution {

    //方法一BFS
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (target.equals(start)) {
            return 0;
        }
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains(start)) {
            return -1;
        }
        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        //向链表末尾添加元素，返回是否成功，成功为 true，失败为 false。
        queue.offer(start);
        Set<String> seen = new HashSet<String>();
        seen.add(start);

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                //删除并返回第一个元素。
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }

    //方法二 双向BFS
    String t, s;
    Set<String> set = new HashSet<>();

    public int openLock2(String[] _ds, String _t) {
        s = "0000";
        t = _t;
        if (s.equals(t)) {
            return 0;
        }
        Collections.addAll(set, _ds);
        if (set.contains(s)) {
            return -1;
        }
        return bfs();
    }

    int bfs() {
        // d1 代表从起点 s 开始搜索（正向）
        // d2 代表从结尾 t 开始搜索（反向）
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        /*
         * m1 和 m2 分别记录两个方向出现的状态是经过多少次转换而来
         * e.g.
         * m1 = {"1000":1} 代表 "1000" 由 s="0000" 旋转 1 次而来
         * m2 = {"9999":3} 代表 "9999" 由 t="9996" 旋转 3 次而来
         */
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.addLast(s);
        m1.put(s, 0);
        d2.addLast(t);
        m2.put(t, 0);

        /*
         * 只有两个队列都不空，才有必要继续往下搜索
         * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
         * e.g.
         * 例如，如果 d1 为空了，说明从 s 搜索到底都搜索不到 t，反向搜索也没必要进行了
         */
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        String poll = deque.pollFirst();
        char[] pcs = poll.toCharArray();
        int step = cur.get(poll);
        // 枚举替换哪个字符
        for (int i = 0; i < 4; i++) {
            // 能「正向转」也能「反向转」，这里直接枚举偏移量 [-1,1] 然后跳过 0
            for (int j = -1; j <= 1; j++) {
                if (j == 0) {
                    continue;
                }

                // 求得替换字符串 str
                int origin = pcs[i] - '0';
                int next = (origin + j) % 10;
                if (next == -1) {
                    next = 9;
                }

                char[] clone = pcs.clone();
                clone[i] = (char) (next + '0');
                String str = String.valueOf(clone);

                if (set.contains(str)) {
                    continue;
                }
                if (cur.containsKey(str)) {
                    continue;
                }

                // 如果在「另一方向」找到过，说明找到了最短路，否则加入队列
                if (other.containsKey(str)) {
                    return step + 1 + other.get(str);
                } else {
                    deque.addLast(str);
                    cur.put(str, step + 1);
                }
            }
        }
        return -1;
    }

    //ASTAR 方法
    public int openLock3(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<String>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) {
            return -1;
        }

        PriorityQueue<AStar> pq = new PriorityQueue<AStar>((a, b) -> a.f - b.f);
        pq.offer(new AStar("0000", target, 0));
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while (!pq.isEmpty()) {
            AStar node = pq.poll();
            for (String nextStatus : get(node.status)) {
                if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                    if (nextStatus.equals(target)) {
                        return node.g + 1;
                    }
                    pq.offer(new AStar(nextStatus, target, node.g + 1));
                    seen.add(nextStatus);
                }
            }
        }

        return -1;
    }


    class AStar {
        String status;
        int f, g, h;

        public AStar(String status, String target, int g) {
            this.status = status;
            this.g = g;
            this.h = getH(status, target);
            this.f = this.g + this.h;
        }

        // 计算启发函数
        public int getH(String status, String target) {
            int ret = 0;
            for (int i = 0; i < 4; ++i) {
                int dist = Math.abs(status.charAt(i) - target.charAt(i));
                ret += Math.min(dist, 10 - dist);
            }
            return ret;
        }

    }


    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(new Solution().openLock3(deadends, target));
    }

}
