import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author wwx-sys
 * @time 2021-12-10-15:48
 * @description 剑指 Offer 50. 第一个只出现一次的字符
 */
public class T50 {
    //队列 + HashSet
    public char firstUniqChar(String s) {
        char res = ' ';
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        for (char t : s.toCharArray()) {
            if (!set.contains(t)){
                queue.add(t);
            }else {
                queue.remove(t);
            }
            set.add(t);
        }
        if (!queue.isEmpty()){
            res = queue.poll();
        }
        return res;
    }

    //有序哈希表
    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }


    public static void main(String[] args) {
        System.out.println(new T50().firstUniqChar("abaccdeff"));
    }
}
