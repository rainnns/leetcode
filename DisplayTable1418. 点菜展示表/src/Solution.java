import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/6 18:27
 */
public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, List<String>> userInfos = new HashMap<>();
        List<String> menu = new ArrayList<>();
        for (List<String> order : orders) {
            String name = order.get(0);
            int tableNumber = Integer.parseInt(order.get(1));
            String menuName = order.get(2);
            if (!menu.contains(menuName)) {
                menu.add(menuName);
            }
            List<String> m;
            if (userInfos.containsKey(tableNumber)) {
                m = userInfos.get(tableNumber);
            } else {
                m = new ArrayList<>();
            }
            m.add(menuName);
            userInfos.put(tableNumber, m);
        }
        List<Map.Entry<Integer, List<String>>> sort = new ArrayList<>();
        userInfos.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(sort::add);

        String[] orderedMenu = menu.toArray(new String[0]);

        Arrays.sort(orderedMenu);

        List<List<String>> ret = new ArrayList<>();

        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(Arrays.asList(orderedMenu));
        ret.add(header);

        for (Map.Entry<Integer, List<String>> integerListEntry : sort) {
            List<String> raw = new ArrayList<>();
            int tableNumber = integerListEntry.getKey();
            List<String> cai = integerListEntry.getValue();
            raw.add(String.valueOf(tableNumber));
            for (String s : orderedMenu) {
                raw.add(String.valueOf(cai.stream().filter(e -> e.equals(s)).count()));
            }
            ret.add(raw);
        }

        return ret;
    }


    public List<List<String>> displayTable2(List<List<String>> orders) {
        // 从订单中获取餐品名称和桌号，统计每桌点餐数量
        Set<String> nameSet = new HashSet<>();
        Map<Integer, Map<String, Integer>> foodsCnt = new HashMap<>();
        for (List<String> order : orders) {
            nameSet.add(order.get(2));
            int id = Integer.parseInt(order.get(1));
            Map<String, Integer> map = foodsCnt.getOrDefault(id, new HashMap<>());
            map.put(order.get(2), map.getOrDefault(order.get(2), 0) + 1);
            foodsCnt.put(id, map);
        }

        // 提取餐品名称，并按字母顺序排列
        int n = nameSet.size();
        List<String> names = new ArrayList<>(nameSet);
        Collections.sort(names);

        // 提取桌号，并按餐桌桌号升序排列
        int m = foodsCnt.size();
        List<Integer> ids = new ArrayList<>(foodsCnt.keySet());
        Collections.sort(ids);

        // 填写点菜展示表
        List<List<String>> table = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(names);
        table.add(header);
        for (int i = 0; i < m; ++i) {
            int id = ids.get(i);
            Map<String, Integer> cnt = foodsCnt.get(id);
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(id));
            for (int j = 0; j < n; ++j) {
                row.add(Integer.toString(cnt.getOrDefault(names.get(j), 0)));
            }
            table.add(row);
        }
        return table;
    }


    public static void main(String[] args) {
        List<String> menu = new ArrayList<>();
        menu.add("Ceviche");
        menu.add("Beef Burrito");
        menu.add("c");
        menu.add("d");
        String[] orderedMenu = menu.toArray(new String[0]);
        Arrays.sort(orderedMenu);
        System.out.println(Arrays.toString(orderedMenu));
    }


}
