import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-07-22-11:16
 * @description 选择排序
 */
public class SelectionSort {
    public int[] sort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,5,1,4,3};
        System.out.println(Arrays.toString(new SelectionSort().sort(nums)));
    }
}
