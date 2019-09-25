package linked_list;

/**
 * @author EvanHsia
 * @ClassName ReverseNodeInKGroup.java
 * @Description No.25 Hard
 * @createTime 2019-09-25- 16:13
 */
public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode sentinel=new ListNode(-1);
        sentinel.next=head;
        int n=0;
        ListNode cur=sentinel;
        while (cur.next!=null){
            cur=cur.next;
            n++;
        }
        ListNode root=sentinel;
        while (n>=k){
            for (int j=0;j<k-1;j++){
                ListNode node=head.next;
                head.next=node.next;
                node.next=root.next;
                root.next=node;
            }
            root=head;
            head=root.next;
            n-=k;
        }
        return sentinel.next;
    }
}
