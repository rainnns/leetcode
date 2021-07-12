/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/7/12 16:28
 */
public class Solution {
    public int hIndex(int[] citations) {
        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) {
                return citations.length - i;
            }
        }
        return 0;
    }

    //二分查找
    public int hIndex2(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int mid = (right + left) / 2;
        while (left <= right) {
            if (citations.length - mid > citations[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (right + left) / 2;
        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{0, 1, 3, 5, 6};
        System.out.println(new Solution().hIndex(citations));
        System.out.println(new Solution().hIndex2(citations));
    }
}
