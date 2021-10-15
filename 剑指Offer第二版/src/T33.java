import java.util.Stack;

/**
 * @author wwx-sys
 * @time 2021-10-14-20:48
 * @description 剑指 Offer 33. 二叉搜索树的后序遍历序列
 */
public class T33 {

    //递归分治
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;

        //确定左子树
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;

        //确定右子树
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    //辅助单调栈
    //方法二是说，我维护一个单调栈，每次遇到大于栈顶元素的点，我们认为它是栈顶元素的右子树上的点。
    // 每次遇到比栈顶元素小的点，我们就循环弹出栈顶元素，直到栈为空或者栈顶元素大于它。这样，最后弹出的节点为它的根。
    // 以上过程一直重复下去，如果都满足r_i小于当前根节点，则返回true，否则返回false。由于我们需要考虑根节点的右子树，所以最初设置当前root值为正无穷。
    public boolean verifyPostorder1(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.empty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

}
