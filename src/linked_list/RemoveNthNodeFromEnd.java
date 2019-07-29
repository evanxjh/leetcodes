package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.19 Medium
 * @author: EvenHsia
 * @create: 2019-07-29 13:58
 **/

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Given n will always be valid.
 */
public class RemoveNthNodeFromEnd {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    //  fast比slow快n个节点，fast到末尾，则slow到倒数n+1个
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast=head;
        while (n-->0){
            fast=fast.next;
        }
        if (fast==null) return head.next;
        ListNode slow=head;
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
