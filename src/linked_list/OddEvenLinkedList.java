package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.328 Medium
 * @author: EvenHsia
 * @create: 2019-07-29 17:20
 **/

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class OddEvenLinkedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public ListNode oddEvenList(ListNode head){
        if (head==null || head.next==null|| head.next.next==null) return head;
        ListNode oddNode=head;
        ListNode evenHead=head.next;
        ListNode evenNode=head.next;
        while (oddNode.next!=null && oddNode.next.next!=null){
            oddNode.next=oddNode.next.next;
            evenNode.next=evenNode.next.next;
            oddNode=oddNode.next;
            evenNode=evenNode.next;
        }
        oddNode.next=evenHead;
        return head;
    }
}
