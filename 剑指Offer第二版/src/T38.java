import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-10-22-17:23
 * @description 剑指 Offer 38. 字符串的排列
 */
public class T38 {
    private List<String> res = new LinkedList<>();
    char[] chars;

    //交换剪枝
    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int x) {
        if (x == chars.length - 1) {
            res.add(String.valueOf(chars));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) continue; // 重复，因此剪枝
            set.add(chars[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                   // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }

    void swap(int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    private HashSet<String> resSet = new HashSet<>();

    public String[] permutation1(String s) {
        dfs(s.toCharArray(), "", new boolean[s.length()]);
        return resSet.toArray(new String[0]);
    }


    public void dfs(char[] arr, String s, boolean[] visited) {
        if (s.length() == arr.length) {
            resSet.add(s);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(arr, s + arr[i], visited);
            visited[i] = false;
        }

    }

}
