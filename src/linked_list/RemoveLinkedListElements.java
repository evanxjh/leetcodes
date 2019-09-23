package linked_list;

/**
 * @author EvanHsia
 * @ClassName RemoveLinkedListElements.java
 * @Description No.203 Easy
 * @createTime 2019-09-20- 11:41
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head,int val){
        ListNode sentinel=new ListNode(-1);
        sentinel.next=head;
        ListNode prev=sentinel;
        while (prev.next!=null){
            if (prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=prev.next.next;
                delNode.next=null;                      //非必须，游离作用
            } else{
                prev=prev.next;
            }
        }
        return sentinel.next;
    }
}
