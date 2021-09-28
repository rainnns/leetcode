import java.util.LinkedList;

import entity.ListNode;

/**
 * @author wwx-sys
 * @time 2021-09-28-11:29
 * @description 剑指 Offer 06. 从尾到头打印链表
 */
public class T06 {

    //栈辅助
    public int[] reversePrint(ListNode head) {
        ListNode cur = head;
        LinkedList<Integer> stack = new LinkedList<>();
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    LinkedList<Integer> list = new LinkedList<>();

    //递归
    public int[] reversePrint1(ListNode head) {
        recur(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.pop();
        }
        return res;
    }

    void recur(ListNode node) {
        if (node == null) {
            return;
        }
        recur(node.next);
        list.add(node.val);
    }

    //两次遍历
    public int[] reversePrint2(ListNode head) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int[] res = new int[n];
        cur = head;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }

}
