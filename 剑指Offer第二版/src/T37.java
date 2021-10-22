import java.util.LinkedList;
import java.util.Queue;

import entity.TreeNode;

/**
 * @author wwx-sys
 * @time 2021-10-22-16:25
 * @description 剑指 Offer 37. 序列化二叉树
 */
public class T37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (sb.length() != 0){
                sb.append(" ");
            }
            if (node == null) {
                sb.append("null");
                continue;
            }
            sb.append(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cursor = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            String leftValue = values[++cursor];
            if (!leftValue.equals("null")){
                node.left = new TreeNode(Integer.parseInt(leftValue));
                queue.add(node.left);
            }
            String rightValue = values[++cursor];
            if (!rightValue.equals("null")){
                node.right = new TreeNode(Integer.parseInt(rightValue));
                queue.add(node.right);
            }
        }
        return root;
    }
}
