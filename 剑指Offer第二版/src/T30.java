import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * @author wwx-sys
 * @time 2021-10-11-15:36
 * @description 剑指 Offer 30. 包含min函数的栈
 */
public class T30 {

    Stack<Integer> minStack;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public T30() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty() || x <= minStack.peek()){
            minStack.add(x);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.pop())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
