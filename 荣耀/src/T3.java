import java.util.Scanner;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/19 18:49
 */
public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineGroup = scanner.nextLine();
        String[] groups = lineGroup.split("\\|");
        //  先对小组进行排序
        // 不排序了，默认小组按人数从低到高排列
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> Integer.parseInt(groups[o])));
//        for (int i = 0; i < groups.length; i++) {
//            queue.add(i);
//        }
//        int[] groupsMember = new int[groups.length];
//        for (int i = 0; i < groups.length; i++) {
//            groupsMember[i] = queue.poll();
//        }
        int[] times = new int[groups.length];
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] es = line.split("\\|");
            int id = Integer.parseInt(es[0]);
            int startTime = Integer.parseInt(es[1]);
            int minNum = Integer.parseInt(es[2]);
            int work = Integer.parseInt(es[3]);
            int day = 0;
            boolean needWait = true;
            int i = 0;
            for (; i < groups.length; i++) {
                //先筛选出人数大于最低人数的小组
                int memNums = Integer.parseInt(groups[i]);
                if (memNums >= minNum && startTime >= times[i]) {
                    needWait = false;
                    day = work * minNum / memNums;
                    times[i] += day;
                    break;
                }
            }
            if (needWait) {
                //按还需要的时间排序
                i = 0;
                int minTime = Integer.MAX_VALUE;
                int minIndex = -1;
                for (; i < groups.length; i++) {
                    int memNums = Integer.parseInt(groups[i]);
                    if (memNums >= minNum) {
                        minTime = Math.min(minTime, times[i]);
                        minIndex = i;
                    }
                }
                if (minIndex != -1){
                    day = work * minNum / Integer.parseInt(groups[minIndex]);
                    times[minIndex] += day;
                }
                startTime = minTime;
            }
            int groupId = i + 1;
            System.out.println(id + "|" + groupId + "|" + startTime + "|" + day);
        }

    }
}

//16|16|16
//1|0|2|320
//2|0|2|160

//1|1|0|40
//2|2|0|20