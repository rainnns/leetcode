import java.util.Stack;

/**
 * @author wwx-sys
 * @time 2021-09-29-10:04
 * @description 剑指 Offer 09. 用两个栈实现队列
 */
public class T09 {

    class CQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public CQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (outStack.empty()) {
                while (!inStack.empty()) {
                    outStack.push(inStack.pop());
                }
            }
            if (outStack.empty()){
                return -1;
            }
            return outStack.pop();
        }
    }
}
