import java.util.Collections;
import java.util.Stack;

/**
 * @author wwx-sys
 * @time 2020-08-28-11:37
 * @description
 */
public class Solution {

    /**
     * 先根据"/"分割，将分割的根据情况分类进栈，最后从栈底进行拼接
     */
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : strings) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (!s.isEmpty() && !s.equals(".")) {
                stack.push(s);
            }
        }
        return "/"+ String.join("/", stack);        //从栈底开始拼接
    }
}
