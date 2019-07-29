package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.24 Medium
 * @author: EvenHsia
 * @create: 2019-07-29 14:09
 **/


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPairs {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public ListNode swapPairs(ListNode head){
        ListNode sentinel=new ListNode(-1);
        sentinel.next=head;
        ListNode current=sentinel;
        while (current.next!=null && current.next.next!=null){
            ListNode node1=current.next;
            ListNode node2=current.next.next;
            node1.next=node2.next;
            node2.next=node1;
            current.next=node2;
            current=node1;
        }
        return sentinel.next;
    }

    //recurse version
    public ListNode swappairsrecurse(ListNode head){
        ListNode sentinel=new ListNode(-1);
        sentinel.next=head;
        sentinel.next=swaphelper(head);
        return sentinel.next;
    }
    private ListNode swaphelper(ListNode first){
        if (first ==null || first.next==null) return first;
        ListNode l1=first;
        ListNode l2=first.next;
        ListNode next=swaphelper(l2.next);
        l2.next=l1;
        l1.next=next;
        return l2;
    }
}
