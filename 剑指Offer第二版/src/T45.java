import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author wwx-sys
 * @time 2021-11-23-11:31
 * @description 剑指 Offer 45. 把数组排成最小的数
 */
public class T45 {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
//        Arrays.sort(strings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        quickSort(strings, 0, n - 1);
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }

    public void quickSort(String[] strings, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        while (i < j) {
            while ((strings[j] + strings[l]).compareTo(strings[l] + strings[j]) >= 0 && i < j) j--;
            while ((strings[i] + strings[l]).compareTo(strings[l] + strings[i]) <= 0 && i < j) i++;
            swap(strings, i, j);
        }
        swap(strings, l, i);
        quickSort(strings, l, i - 1);
        quickSort(strings, i + 1, r);
    }

    public int getPivot(String[] strings, int l, int r) {
        String index = strings[l];
        int p = l;
        for (int i = l; i <= r; i++) {
            if ((strings[i] + index).compareTo(index + strings[i]) < 0) {
                p++;
                swap(strings, i, p);
            }
        }
        swap(strings, l, p);
        return p;
    }

    public void swap(String[] strings, int l, int r) {
        String temp = strings[l];
        strings[l] = strings[r];
        strings[r] = temp;
    }


    public LinkedList<Integer> getMods(int num) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (num != 0) {
            linkedList.addFirst(num % 10);
            num /= 10;
        }
        return linkedList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        System.out.println(new T45().minNumber(nums));
    }
}
