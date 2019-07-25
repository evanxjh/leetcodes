package two_pointers;

/**
 * @program: leetcodetrain
 * @description: No.141 Easy
 * @author: EvenHsia
 * @create: 2019-07-25 23:13
 **/

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed)
 * in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 */
public class LinkedListCycle {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    //两个指针，一个步长为1，一个步长为2，如果有环，肯定会重合
    public boolean hasCycle(ListNode head){
        if (head==null) return false;
        ListNode pointer1=head;
        ListNode pointer2=head;
        while (pointer1.next!=null && pointer2.next!=null && pointer2.next.next!=null){
            pointer1=pointer1.next;
            pointer2=pointer2.next.next;
            if (pointer1.val==pointer2.val){
                return true;
            }
        }
        return false;
    }
}
