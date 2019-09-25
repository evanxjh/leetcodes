package linked_list;

/**
 * @author EvanHsia
 * @ClassName ReverseLinkedListII.java
 * @Description No.92 Medium
 * @createTime 2019-09-25- 15:25
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head,int m,int n){
        ListNode sentinel=new ListNode(-1);
        sentinel.next=head;
        ListNode pre=sentinel;
        for (int i=1;i<m;i++){
            pre=pre.next;
        }
        ListNode nodeM=pre.next;
        for (int i=0;i<n-m;i++){
            //头插法
            ListNode next=nodeM.next;
            nodeM.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return sentinel.next;
    }
}
