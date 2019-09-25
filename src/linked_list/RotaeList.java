package linked_list;

/**
 * @author EvanHsia
 * @ClassName RotaeList.java
 * @Description No.61 Medium
 * @createTime 2019-09-25- 16:33
 */
public class RotaeList {
    public ListNode rotateRight(ListNode head,int k){
        int len=0;
        ListNode cur=head;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        if (len==0){
            return head;
        }
        k=k%len;
        if (k==0){
            return head;
        }



        ListNode fast=head;
        while (k-->0){
            fast=fast.next;
        }
        ListNode slow=head;
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode newhead=slow.next;
        slow.next=null;
        fast.next=head;
        return newhead;
    }
}
