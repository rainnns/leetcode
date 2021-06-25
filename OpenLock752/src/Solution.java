import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/25 16:22
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        if (target.equals(start)){
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

}
