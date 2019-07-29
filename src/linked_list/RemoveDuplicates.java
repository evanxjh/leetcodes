package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.83 Easy
 * @author: EvenHsia
 * @create: 2019-07-29 13:31
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicates {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public ListNode deleteDuplicates(ListNode head){
        if (head==null) return null;
        ListNode pointer=head;
        while (pointer!=null) {
            ListNode nextnode=pointer.next;
            if (nextnode==null) return head;
            if (pointer.val!=nextnode.val){
                pointer=nextnode;
            }else{
                pointer.next=nextnode.next;
            }
        }
        return head;
    }
    //recurse version
    public ListNode removeDuplicates(ListNode head){
        if (head==null || head.next==null) return head;
        head.next=removeDuplicates(head.next);
        if (head.val==head.next.val){
            return head.next;
        }else {
            return head;
        }
    }
}
