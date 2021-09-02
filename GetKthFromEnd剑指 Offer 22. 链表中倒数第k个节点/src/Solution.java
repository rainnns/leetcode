import java.util.ArrayList;
import java.util.List;

/**
 * @author wwx-sys
 * @time 2021-09-02-14:52
 * @description
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }
        return listNodes.get(listNodes.size() - k);
    }


    //先求出整体长度
    public ListNode getKthFromEnd1(ListNode head, int k) {
        int n = 0;
        ListNode node = null;
        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }
        return node;
    }

    //快慢指针
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


}
