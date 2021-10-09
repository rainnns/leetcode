import entity.TreeNode;

/**
 * @description:
 * @author: black-wang
 * @createDate: 2021/10/9 14:08
 */
public class T26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return bfs(A, B);
    }

    public boolean bfs(TreeNode node, TreeNode B) {
        if (node == null) {
            return false;
        }
        if (node.val == B.val && isEqual(node, B)) {
            return true;
        } else return bfs(node.left, B) || bfs(node.right, B);
    }

    public boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
    }

}
