import java.util.Arrays;
import java.util.Random;

/**
 * @author wwx-sys
 * @time 2021-09-04-10:15
 * @description 双路快排
 */
public class QuickSort2Ways {

    private int partition(int[] arr, int left, int right) {
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        int pivot = arr[left];
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= right && arr[i] < pivot) {
                i++;
            }
            while (j >= left + 1 && arr[j] > pivot) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public void sort(int[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        QuickSort2Ways q = new QuickSort2Ways();
        int[] arr = new int[]{4, 5, 3, 1, 56, 8, 2};
        q.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
