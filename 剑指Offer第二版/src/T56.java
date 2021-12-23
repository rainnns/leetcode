/**
 * @author wwx-sys
 * @time 2021-12-23-15:03
 * @description 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class T56 {
    // nums=[x,y,a,a,b,b,c,c] ,不重复的则为x , y
    //1、遍历数组，整体进行异或运算，结果为 z =  x⊕y
    //2、循环左移1与z进行 与运算，找到z中第一个不为0的数在哪一位,这个数的二进制 记为 m
    //3、再遍历数组nums，逐个与 m 进行 与运算，结果为 0 的分到 n1 数组如 [x,a,a,b,b] 结果为 1的分到 n2 数组 [y,c,c] ; 这一步是为了将x 和 y 分开
    //4、再分别对 n1 和 n2 进行 异或运算， 结果则 为 x 和 y
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, m = 1, n = 0;
        for (int num : nums) {
            n ^= num;
        }
        while ((n & m) == 0) {
            m <<= 1;
        }
        for (int num : nums) {
            if ((num & m) == 0){
                x ^= num;
            }
            else {
                y ^= num;
            }
        }
        return new int[]{x,y};
    }
}
