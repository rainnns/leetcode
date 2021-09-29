import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/9/29 19:48
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int relaNum = Integer.parseInt(scanner.nextLine());
        String target = scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        Map<String, List<String>> from2map = new HashMap<>();
        for (int i = 0; i < relaNum; i++) {
            String line = scanner.nextLine();
            String[] splits = line.split(" ");
            String current = splits[0];
            String from = splits[1];
            String to = splits[2];
            if (!to.equals("null")) {
                map.put(to, current);

                List<String> list = from2map.get(current);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(to);
                from2map.put(current, list);
            }
        }
        String cur = target;
        int count = 1;
        //通向target的
        while (map.containsKey(cur)) {
            cur = map.get(cur);
            count++;
        }
        //target通向的
        count += dfs(target, from2map);
        System.out.println(count);
    }

    public static int dfs(String t, Map<String, List<String>> map) {
        List<String> list = map.get(t);
        if (list == null) {
            return 0;
        }
        int res = 0;
        for (String s : list) {
            res = Math.max(res, dfs(s, map) + 1);
        }
        return res;
    }

}

//4
//device1
//device1 device2 device3
//device2 null device1
//device3 device1 device4
//device4 device3 null