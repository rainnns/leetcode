import entity.ListNode;

/**
 * @author wwx-sys
 * @time 2021-10-08-15:07
 * @description 剑指 Offer 22. 链表中倒数第k个节点
 */
public class T22 {
    //快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head ,slow = head;
        while (fast != null && k > 0){
            fast = fast.next;
            k --;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
