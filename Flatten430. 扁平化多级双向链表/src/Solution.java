/**
 * @author wwx-sys
 * @time 2021-09-24-20:57
 * @description
 */
public class Solution {
    Node current;
    public Node flatten(Node head) {
        Node res = new Node();
        current = res;
        dfs(head);
        Node t = res.next;
        if (t != null) {
            t.prev = null;
        }
        return t;
    }

    public void dfs(Node s) {
        if (s == null) {
            return;
        }
        Node t = new Node();
        t.val = s.val;
        current.next = t;
        t.prev = current;
        current = t;
        dfs(s.child);
        dfs(s.next);
    }

}

