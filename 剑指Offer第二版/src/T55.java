import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-12-21-15:35
 * @description 剑指 Offer 55 - I. 二叉树的深度
 */
public class T55 {
    int depth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root,0);
        return depth;
    }

    void dfs(TreeNode node , int currentDepth){
        if (node == null){
            depth = Math.max(depth,currentDepth);
            return;
        }
        dfs(node.left,currentDepth + 1);
        dfs(node.right,currentDepth + 1);
    }
}
