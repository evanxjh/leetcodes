package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.21
 * @author: EvenHsia
 * @create: 2019-07-27 14:39
 **/

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l1.val<=l2.val){
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode sentinel=new ListNode(-1);
        ListNode cur=sentinel;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
            } else {
                cur.next=l2;
                l2=l2.next;
                cur=cur.next;
            }
        }
        if (l1!=null){
            cur.next=l1;
        }
        if (l2!=null){
            cur.next=l2;
        }
        return sentinel.next;
    }
}
