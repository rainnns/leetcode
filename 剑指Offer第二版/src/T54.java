import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-12-20-15:30
 * @description 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class T54 {
    int k;
    int res;

    //二叉搜索树的中序遍历（左、根、右）是递增序列，那么中序遍历倒序（右、根、左）为递减序列
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = node.val;
            return;
        }
        dfs(node.left);
    }
}
