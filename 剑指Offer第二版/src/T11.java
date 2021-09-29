/**
 * @author wwx-sys
 * @time 2021-09-29-15:21
 * @description 剑指 Offer 11. 旋转数组的最小数字
 */
public class T11 {
    //二分
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j){
            int m = (i + j) >> 1;
            if (numbers[m] > numbers[j]){
                i = m + 1;
            }
            else if (numbers[m] < numbers[j]){
                j = m;
            }else {
                j--;
            }
        }
        return numbers[i];
    }

    public int minArray1(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
