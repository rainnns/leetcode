import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-07-22-16:59
 * @description 归并排序
 */
public class MergeSort {
    /**
     *
     算法步骤
    1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；

    2、设定两个指针，最初位置分别为两个已经排序序列的起始位置；

    3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；

    4、重复步骤 3 直到某一指针达到序列尾；

    5、将另一序列剩下的所有元素直接复制到合并序列尾。

     */
    public int[] sort(int[] nums) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(nums, nums.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    protected int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,7,2,9,5};
        System.out.println(Arrays.toString(new MergeSort().sort(nums)));
    }
}
