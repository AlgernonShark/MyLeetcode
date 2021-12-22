package december;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 遍历节点
        ListNode list = head;
        for (int i = 0; i < n; i++){
            list = list.next;
        }

        // n为数组长度，即删掉头结点的情况
        if (list == null) {
            if (n == 1) return null;
            else return head.next;
        }

        // 待删除节点的前驱节点
        ListNode pre = head;

        // list指向链表末尾节点（list.next == null）时，pre指向待删除节点的前驱
        while (list.next != null) {
            list = list.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return head;

    }
}

class MySolution1 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        // 注意与找到倒数第K个元素的区别
        // 一个慢指针指向这个元素，一个慢指针指向其前驱
        // 还要注意删除头结点的情况
        ListNode fast = head;
        while(fast != null && n > 0){
            fast = fast.next;
            n--;
        }

        // 删掉头结点
        if (fast == null) return head.next;

        // 一个慢指针指向其前驱，距离+1，因此有fast = fast.next;
        fast = fast.next;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
