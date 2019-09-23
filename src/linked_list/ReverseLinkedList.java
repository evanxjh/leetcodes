package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.206 Easy
 * @author: EvenHsia
 * @create: 2019-07-27 13:10
 **/

import org.junit.Test;

/**
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }

    //recursively version
    public ListNode reverseList(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode next=head.next;
        ListNode newhead=reverseList(next);
        next.next=head;
        head.next=null;
        return newhead;
    }

    //iteratively version  头插法
    public ListNode reverselist(ListNode head){
        ListNode sentinal=new ListNode(-1);
        while (head!=null){
            ListNode next=head.next;
            head.next=sentinal.next;
            sentinal.next=head;
            head=next;
        }
        return sentinal.next;
    }

    //方法三定义pre cur next
    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;

        while(cur!=null){
            ListNode next = cur.next;
            // next指针指向的元素实际上就是 cur指针的指向的下一个元素

            //反转链表
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    @Test
    public void sometest(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode newlist=reverseList(l1);
    }


}
