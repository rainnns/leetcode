import java.util.Stack;

/**
 * @author wwx-sys
 * @time 2020-08-25-15:19
 * @description
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty()) {
                char matchCharacter = 0;
                switch (stack.peek()) {
                    case '(' -> matchCharacter = ')';
                    case '[' -> matchCharacter = ']';
                    case '{' -> matchCharacter = '}';
                }
                if (s.charAt(i) == matchCharacter) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}
