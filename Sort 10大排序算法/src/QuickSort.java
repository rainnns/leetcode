import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-09-03-17:34
 * @description
 */


public class QuickSort {

    //方式一
    public void quickSort1(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort1(nums, l, p - 1);
        quickSort1(nums, p + 1, r);
    }

    public int partition(int[] nums, int left, int right) {
        //设定基准值
        int pivot = nums[left];
        int index = left;
        for (int i = index; i <= right; i++) {
            if (nums[i] < pivot) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, left, index);
        return index;
    }

    public void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    public void quickSort2(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int i = l, j = r;
        int pivot = nums[l];
        while (i < j) {
            while (nums[j] >= pivot && i < j) j--;
            while (nums[i] <= pivot && i < j) i++;
            swap(nums, i, j);
        }
        swap(nums, l, i);
        quickSort2(nums, l, i - 1);
        quickSort2(nums, i + 1, r);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 7, 6, 4, 1, 0, 2, 9, 10, 8};
//        new QuickSort().sort(arr);
        new QuickSort().quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
