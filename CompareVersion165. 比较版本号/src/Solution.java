/**
 * @author wwx-sys
 * @time 2021-09-01-14:55
 * @description
 */
public class Solution {

    //字符串分割
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    //双指针
    public int compareVersion1(String version1, String version2) {
        int n1 = version1.length(), n2 = version2.length();
        int p1 = 0, p2 = 0;
        while (p1 < n1 || p2 < n2) {
            int x = 0;
            for (; p1 < n1 && version1.charAt(p1) != '.'; p1++) {
                x = x * 10 + version1.charAt(p1) - '0';
            }
            p1++;

            int y = 0;
            for (; p2 < n2 && version2.charAt(p2) != '.'; p2++) {
                y = y * 10 + version2.charAt(p2) - '0';
            }
            p2++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion1("7.5.2.4", "7.5.3"));
    }
}
