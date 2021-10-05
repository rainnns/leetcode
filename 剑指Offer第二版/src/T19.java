/**
 * @author wwx-sys
 * @time 2021-10-02-17:48
 * @description 剑指 Offer 19. 正则表达式匹配
 */
public class T19 {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            char a = s.charAt(i);
            char b = p.charAt(j);
            if (a == b) {
                i++;
                j++;
                continue;
            }
            if (a == '_' || b == '_') {
                i = a == '_' ? i + 1 : i;
                j = b == '_' ? j + 1 : j;
            }
        }

        return true;
    }
}
