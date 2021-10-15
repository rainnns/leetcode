import java.util.Stack;

/**
 * @author wwx-sys
 * @time 2021-10-12-17:26
 * @description 剑指 Offer 31. 栈的压入、弹出序列
 */
public class T31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            stack.push(pushed[i++]);
            while (!stack.empty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,3,5,1,2};
        System.out.println(new T31().validateStackSequences(pushed,popped));
    }
}
