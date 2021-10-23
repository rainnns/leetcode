import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-09-03-17:34
 * @description
 */


public class QuickSort {

    //随机快排
    public int partitionRandom(int[] nums, int l, int r) {
        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++)
            if (nums[i] < v) {
                j++;
                swap(nums, j, i);
            }
        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partitionRandom(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public void sort(int[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    //普通快排
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

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,3,7,6,4,1,0,2,9,10,8};
//        new QuickSort().sort(arr);
        new QuickSort().quickSort(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));
    }


}
