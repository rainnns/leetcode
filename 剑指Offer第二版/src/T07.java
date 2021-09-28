import entity.TreeNode;

import java.util.HashMap;

/**
 * @author wwx-sys
 * @time 2021-09-28-11:59
 * @description 剑指 Offer 07. 重建二叉树
 */
public class T07 {
    //用来存放inorder，方便根据值找到Index
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, preorder.length - 1);
    }

    /**
     * @param root  当前root在先序遍历数组中的index
     * @param left  当前树在中序遍历数组中的左边界
     * @param right 当前数在中序遍历数组中的右边界
     * @return
     */
    public TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int inorderRootIndex = map.get(preorder[root]);
        node.left = recur(root + 1, left, inorderRootIndex - 1);
        node.right = recur(inorderRootIndex - left + 1 + root, inorderRootIndex + 1, right);
        return node;
    }

}
