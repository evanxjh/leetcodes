package linked_list.Test;

import linked_list.ListNode;

/**
 * @author EvanHsia
 * @ClassName CreateLinkedList.java
 * @Description 根据数组创建链表
 * @createTime 2019-09-25- 15:35
 */
public class CreateLinkedList {
    static ListNode createLinkedList(int[] arr){
        if (arr.length==0)
            return null;
        ListNode head=new ListNode(arr[0]);
        ListNode curNode=head;
        for (int i=1;i<arr.length;i++){
            curNode.next=new ListNode(arr[i]);
            curNode=curNode.next;
        }
        return head;
    }
}
