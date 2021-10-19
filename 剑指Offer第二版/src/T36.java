/**
 * @author wwx-sys
 * @time 2021-10-19-16:32
 * @description 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class T36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node left, right;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        recur(root);
        right.right = left;
        left.left = right;
        return left;
    }

    public void recur(Node node) {
        if (node == null) {
            return;
        }
        recur(node.left);
        if (right == null) {
            left = node;
        }else {
            right.right = node;
        }
        node.left = right;
        right = node;
        recur(node.right);
    }
}
