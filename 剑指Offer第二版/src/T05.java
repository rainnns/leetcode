/**
 * @author wwx-sys
 * @time 2021-09-28-11:23
 * @description 剑指 Offer 05. 替换空格
 */
public class T05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
