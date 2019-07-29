package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.234 Easy
 * @author: EvenHsia
 * @create: 2019-07-29 15:30
 **/

/**
 * Given a singly linked list, determine if it is a palindrome.
 * O(n) time and O(1) space
 */
public class PalindromeLinkedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public boolean isPalindrome(ListNode head){
        if (head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null && fast.next!=null){             //找到中间节点
            fast=fast.next.next;
            slow=slow.next;
        }
        if (fast!=null) {                                  //偶数个节点
            slow=slow.next;
        }
        cut(head,slow);
        return isEqual(head,reverse(slow));
    }

    private void cut(ListNode head,ListNode medium){
        while (head.next!=medium){
            head=head.next;
        }
        head.next=null;
    }
    private ListNode reverse(ListNode head){
        if (head==null || head.next==null) return head;
        ListNode next=head.next;
        ListNode newHead=reverse(next);
        next.next=head;
        head.next=null;
        return newHead;
    }

    private boolean isEqual(ListNode l1,ListNode l2){
        while (l1!=null && l2!=null){
            if (l1.val!=l2.val) return false;
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
}
