package Tree;

/**
 * @program: leetcodetrain
 * @description: No.109 Medium
 * @author: EvenHsia
 * @create: 2019-08-02 14:31
 **/
public class BSTConvertSortedList {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public TreeNode sortedListToBST(ListNode head){
        if (head==null) return null;
        if (head.next==null) return new TreeNode(head.val);
        ListNode preMid=preMid(head);
        ListNode mid=preMid.next;
        preMid.next=null;                             //裂开
        TreeNode root=new TreeNode(mid.val);
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
    }

    // 返回mid的前一项
    private ListNode preMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode pre=head;
        while (fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return  pre;
    }
}
