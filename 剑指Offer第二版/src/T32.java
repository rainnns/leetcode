import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-10-12-17:47
 * @description 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class T32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
