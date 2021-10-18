import java.util.HashMap;
import java.util.Map;

/**
 * @author wwx-sys
 * @time 2021-10-18-11:33
 * @description 剑指 Offer 35. 复杂链表的复制
 */
public class T35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //哈希表
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

    //拼接+拆分
    public Node copyRandomList1(Node head) {
        if (head == null) {
            return null;
        }
        //1、复制各节点，拼接链表
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            Node next = cur.next;
            newNode.next = next;
            cur.next = newNode;
            cur = next;
        }

        //2、构建各新节点的random指向
        cur = head;
        while (cur != null) {
            Node newNode = cur.next;
            if (cur.random != null) {
                newNode.random = cur.random.next;
            }
            cur = newNode.next;
        }

        //3、拆分，并还原原链表
        Node pre = head;
        Node res = head.next;
        cur = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        //单独处理原链表尾节点
        pre.next = null;
        return res;
    }


}
