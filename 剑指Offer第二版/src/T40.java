import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-10-23-10:08
 * @description 剑指 Offer 40. 最小的k个数
 */
public class T40 {

    //基于快速排序的数组划分
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort1(arr, 0, arr.length - 1, k);
    }

    private int[] quickSort(int[] arr, int l, int r, int k) {
        int index = l;
        int pivot = arr[l];
        for (int i = l; i <= r; i++) {
            if (arr[i] < pivot) {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, l, index);
        if (k < index) {
            return quickSort(arr, l, index - 1, k);
        }
        if (k > index) {
            return quickSort(arr, index + 1, r, k);
        }
        return Arrays.copyOf(arr, k);
    }

    private int[] quickSort1(int[] arr, int l, int r, int k) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, l, i - 1, k);
        if (i < k) return quickSort(arr, i + 1, r, k);
        return Arrays.copyOf(arr, k);
    }


    private void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 21, 3, 4, 9, 7, 2, 10, 5};
        System.out.println(Arrays.toString(new T40().getLeastNumbers(arr, 3)));
    }
}
