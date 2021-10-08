import entity.ListNode;

/**
 * @author wwx-sys
 * @time 2021-10-08-16:46
 * @description 剑指 Offer 25. 合并两个排序的链表
 */
public class T25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode cur = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return node.next;
    }
}
