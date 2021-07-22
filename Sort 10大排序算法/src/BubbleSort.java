import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-07-22-10:40
 * @description 冒泡排序
 */
public class BubbleSort {
    public int[] sort(int[] nums) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    //加入isSorted 的 flag 进行改良
    //当前一轮没有进行交换时，说明数组已经有序，没有必要再进行下一轮的循环了，直接退出。
    public int[] sort2(int[] nums) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
        return arr;
    }
}
