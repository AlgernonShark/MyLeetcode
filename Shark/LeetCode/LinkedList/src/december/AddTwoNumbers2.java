package december;


import org.junit.Test;

public class AddTwoNumbers2 {
    @Test
    public void test(){

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        //三个指针l1、l2、list分别用于遍历三个链表：l1、l2、结果链表

        //记录结果链表的头结点
        ListNode head = new ListNode(0);
        //遍历结果链表
        ListNode list = new ListNode(0);

        //结果链表某一节点的值
        int value = 0;
        //是否进位
        int carry = 0;
        //链表长度——实际上只在确定头结点位置的时候用到
        int length = 0;

        //遍历条件：遍历剩余的l1或l2不为空
        while (l1 != null || l2 != null){

            //
            if (l1 == null && l2 != null) {

                value = (l2.val + carry ) % 10;
                carry = (l2.val + carry ) / 10;

                l2 = l2.next;
            }

            if (l2 == null && l1 != null){

                value = (l1.val + carry ) % 10;
                carry = (l1.val + carry ) / 10;

                l1 = l1.next;
            }

            if(l1 != null && l2 != null) {
                value = (l1.val + l2.val + carry ) % 10;
                carry = (l1.val + l2.val + carry ) / 10;

                l1 = l1.next;
                l2 = l2.next;
            }

            //节点赋值
            list.val = value;
            //确定头结点
            if (length == 0) head = list;

            //非边界情况——l1或l2链表还没有被遍历完，则新建结果链表节点并指针后移
            if (l1 != null || l2 != null){
                list.next = new ListNode();
                list = list.next;
                length++;
            }

            //边界情况：长度更长链表的被遍历完毕，检查最高位是否有进位
            if(l1 == null && l2 == null && carry == 1){
                list.next = new ListNode(1);
                length++;
            }

        }

        return head;
    }





}
