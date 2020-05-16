class SolutionTest {

    @org.junit.jupiter.api.Test
    void reverseKGroup() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next =  new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode h = solution.reverseKGroup(head,1);
        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }
}