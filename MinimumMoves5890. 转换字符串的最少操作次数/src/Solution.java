/**
 * @author wwx-sys
 * @time 2021-10-03-10:30
 * @description
 */
public class Solution {
    public int minimumMoves(String s) {
        int n = s.length();
        int i = 0, count = 0;
        while (i < n) {
            if (s.charAt(i) == 'X') {
                i += 3;
                count++;
            }else {
                i++;
            }
        }
        return count;
    }
}
