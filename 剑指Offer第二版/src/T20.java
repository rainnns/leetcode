import java.util.HashMap;
import java.util.Map;

/**
 * @author wwx-sys
 * @time 2021-10-07-15:33
 * @description 剑指 Offer 20. 表示数值的字符串
 */
public class T20 {
    //有限状态自动机;根据字符类型和合法数值的特点，先定义状态，再画出状态转移图，最后编写代码即可。
//    状态定义：
//按照字符串从左到右的顺序，定义以下 9 种状态。
//    0 开始的空格
//    1 幂符号前的正负号
//    2 小数点前的数字
//    3 小数点、小数点后的数字
//    4 当小数点前为空格时，小数点、小数点后的数字
//    5 幂符号
//    6 幂符号后的正负号
//    7 幂符号后的数字
//    8 结尾的空格
    //合法的结束状态有 2, 3, 7, 8 。

    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap<>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},                           // 0.开始的空格
                new HashMap<>() {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.幂符号前的正负号
                new HashMap<>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},                           // 2.小数点前的数字
                new HashMap<>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},                           // 3.小数点、小数点后的数字
                new HashMap<>() {{
                    put('d', 3);
                }},                           // 4.当小数点前为空格时，小数点、小数点后的数字
                new HashMap<>() {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.幂符号
                new HashMap<>() {{
                    put('d', 7);
                }},                           // 6.幂符号后的正负号
                new HashMap<>() {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.幂符号后的数字
                new HashMap<>() {{
                    put(' ', 8);
                }}                            // 8.结尾的空格

        };
        int p = 0;
        char t;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else { 
                t = '?';
            }
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;

    }

}
