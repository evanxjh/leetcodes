package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.160 Easy
 * @author: EvenHsia
 * @create: 2019-07-27 12:39
 **/

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    /*
     * 思路：A=a+c;B=b+c. c为共同部分，则a+c+b=b+c+a,所以分别遍历A和B，到末尾时分别接上B和A，则会在相同节点相遇
     * 如果没有相同的，则a+b=b+a，最后会在null相遇，即返回null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode node1=headA;
        ListNode node2=headB;
        while (node1!=node2) {
            node1= (node1==null)?headB:node1.next;
            node2= (node2==null)?headA:node2.next;
        }
        return node1;
    }
}
