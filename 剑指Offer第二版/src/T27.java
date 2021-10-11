import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-10-11-10:22
 * @description 剑指 Offer 27. 二叉树的镜像
 */
public class T27 {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        dfs(node.left);
        dfs(node.right);
    }
}
