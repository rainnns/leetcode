import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-10-18-9:59
 * @description 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class T34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    public void recur(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (0 == target && node.left == null && node.right == null) {
            res.add(new LinkedList<>(path));
            //这里不加return,是为了保证这一次添加的元素被移除，下一次的回溯不受到影响
            //return;
        }
        recur(node.left, target);
        recur(node.right, target);
        path.removeLast();
    }

}
