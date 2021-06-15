import java.util.*;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/6/15 18:45
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayNum = in.nextInt();
        List<Integer> array = new ArrayList<>();    //按原顺序排列的数组

        int minNum = 100000;
        int maxNum = 1;
        for (int i = 0; i < arrayNum; i++) {
            int num = in.nextInt();
            array.add(num);
            if (minNum >= num) minNum = num;
            if (maxNum <= num) maxNum = num;
        }
        //排序
        List<Integer> orderedArray = new ArrayList<>(List.copyOf(array));
        Collections.sort(orderedArray);

        int stepCount = 0;
        while (minNum != maxNum) {
            int first = array.get(0);
            array.remove(0);
            if (first == minNum) {
                minNum = orderedArray.get(arrayNum - array.size());
            } else {
                array.add(first);
            }
            stepCount += 1;
        }
        //数组中还有最后一个元素，拿出来操作步骤+1
        System.out.println(stepCount + 1);

    }

    public static void main2(String[] args) {

    }




}
