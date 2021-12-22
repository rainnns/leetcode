import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-12-22-9:55
 * @description 剑指 Offer 55 - II. 平衡二叉树
 */
public class T55_2 {

    //先序遍历 + 判断深度
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        return Math.abs(getDepth(root.left, 0) - getDepth(root.right, 0)) <= 1;
    }

    int getDepth(TreeNode node, int curDepth) {
        if (node == null) {
            return curDepth;
        }
        return Math.max(getDepth(node.left, curDepth + 1), getDepth(node.right, curDepth + 1));
    }


    //后序遍历 + 剪枝
    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    int recur(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = recur(node.left);
        if (left == -1) {
            //剪枝
            return -1;
        }
        int right = recur(node.right);
        if (right == -1) {
            //剪枝
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;

    }

}
