import entity.ListNode;

/**
 * @author wwx-sys
 * @time 2021-10-02-17:31
 * @description 剑指 Offer 18. 删除链表的节点
 */
public class T18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (pre == null) {
                    return head.next;
                }
                pre.next = cur.next;
                return head;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
