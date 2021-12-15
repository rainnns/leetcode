import entity.ListNode;

/**
 * @author wwx-sys
 * @time 2021-12-15-16:24
 * @description 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class T52 {
    //若两链表 有 公共尾部 (即 c>0 ) ：指针 A , B 同时指向「第一个公共节点」node 。
    //若两链表 无 公共尾部 (即 c=0 ) ：指针 A , B 同时指向 null 。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        return nodeA;
    }
}
