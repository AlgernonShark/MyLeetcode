package december;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 用于遍历的节点
        ListNode fast = head, slow = head;

        while(fast != null && k > 0){
            fast = fast.next;
            k--;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
