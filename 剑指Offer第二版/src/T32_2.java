import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-10-12-18:03
 * @description 剑指 Offer 32 - II. 从上到下打印二叉树 II
 */
public class T32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        while (!queue.isEmpty()){
            List<Integer> t = new ArrayList<>();
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                t.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            list.add(t);
        }
        return list;
    }
}
