/**
 * @author wwx-sys
 * @time 2021-08-17-14:18
 * @description
 */
public class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA == 2) {
                    return false;
                }
            }
            if (i + 2 < s.length() && s.charAt(i) == 'L' && s.charAt(i + 1)== 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }
        return true;
    }


}
