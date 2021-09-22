import java.util.Arrays;

/**
 * @author wwx-sys
 * @time 2021-09-22-20:20
 * @description
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        //先遍历一遍，计算出链表的长度
        int n = 0;
        for (ListNode t = head; t != null; t = t.next) {
            n++;
        }
        int average = n / k;
        int mod = n % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode headers = head;
        for (int i = 0; i < k && headers != null; i++) {
            listNodes[i] = headers;
            int partSize = average + (i < mod ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                headers = headers.next;
            }
            ListNode t = headers.next;
            headers.next = null;
            headers = t;
        }
        return listNodes;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 =new ListNode(1,node2);
        System.out.println(Arrays.toString(new Solution().splitListToParts(node1, 5)));
    }
}
