import java.util.HashMap;
import java.util.Map;

/**
 * @author wwx-sys
 * @time 2021-07-22-15:11
 * @description
 */
public class Solution {


    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        final Node preHead = new Node(0);
        Node sourceCurrentNode = head;
        Node resCurrentNode = new Node(head.val);
        int currentIndex = 0;
        Map<Node, Node> sourceNResMap = new HashMap<>();
        while (sourceCurrentNode != null) {
            if (currentIndex == 0) {
                preHead.next = new Node(sourceCurrentNode.val);
                resCurrentNode = preHead.next;
            } else {
                resCurrentNode.next = new Node(sourceCurrentNode.val);
                resCurrentNode = resCurrentNode.next;
            }
            sourceNResMap.put(sourceCurrentNode, resCurrentNode);
            sourceCurrentNode = sourceCurrentNode.next;
            currentIndex += 1;
        }
        sourceCurrentNode = head;
        while (sourceCurrentNode != null) {
            Node resNode = sourceNResMap.get(sourceCurrentNode);
            resNode.random = sourceCurrentNode.random == null ? null : sourceNResMap.get(sourceCurrentNode.random);
            sourceCurrentNode = sourceCurrentNode.next;
        }
        return preHead.next;
    }

    //回溯 + 哈希表
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    //原地处理，将克隆结点放在原结点后面，在原链表上处理克隆结点的random指针，最后分离两个链表
    public Node copyRandomList3(Node head) {
        if(head == null){
            return head;
        }
        // 空间复杂度O(1)，将克隆结点放在原结点后面
        Node node = head;
        // 1->2->3  ==>  1->1'->2->2'->3->3'
        while(node != null){
            Node clone = new Node(node.val);
            clone.next = node.next;
            clone.random = null;
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        // 处理random指针
        node = head;
        while(node != null){
            // ！！
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 还原原始链表，即分离原链表和克隆链表
        node = head;
        Node cloneHead = head.next;
        while(node.next != null){
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }


    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node1.random = null;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        Node head = new Solution().copyRandomList3(node1);
        while (head != null) {
            System.out.println(head.val);
            if (head.random == null) {
                System.out.println("null");
            } else {
                System.out.println(head.random.val);
            }

            head = head.next;
        }
    }
}
