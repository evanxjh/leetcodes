package linked_list;

/**
 * @author EvanHsia
 * @ClassName RemoveDuplicatesII.java
 * @Description No.82 Medium
 * @createTime 2019-09-24- 21:13
 */
public class RemoveDuplicatesII {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public ListNode deleteDuplicates(ListNode head){
        if (head ==null ||head.next==null) {
            return head;
        }
        if (head.val==head.next.val){
            head=head.next.next;
            return deleteDuplicates(head);
        } else {
            head.next=deleteDuplicates(head.next);
            return head;
        }
    }

    public ListNode deleteDuplicates2(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode sentinel = new ListNode(-1);
        sentinel.next=head;
        ListNode pre=sentinel;
        ListNode cur=pre.next;
        while (cur.next!=null){
           if (cur.val!=cur.next.val){
               if (pre.next==cur){
                   pre=cur;
               }else {
                   pre.next=cur.next;
               }
           }
           cur=cur.next;
        }
        if (pre.next!=cur){
            pre.next=null;
        }
        return sentinel.next;
    }
}
