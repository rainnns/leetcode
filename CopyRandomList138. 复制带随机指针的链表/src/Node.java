/**
 * @author wwx-sys
 * @time 2021-07-22-16:01
 * @description
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}