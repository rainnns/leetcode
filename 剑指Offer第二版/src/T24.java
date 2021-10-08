import entity.ListNode;

/**
 * @author wwx-sys
 * @time 2021-10-08-15:12
 * @description 剑指 Offer 24. 反转链表
 */
public class T24 {

    //头插法
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode t = newHead.next;
            newHead.next = new ListNode(cur.val);
            newHead.next.next = t;
            cur = cur.next;
        }
        return newHead.next;
    }

    //迭代
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        return prev;
    }
}
