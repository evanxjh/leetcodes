package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.725 Medium
 * @author: EvenHsia
 * @create: 2019-07-29 16:11
 **/

import java.util.List;

/**
 * Given a (singly) linked list with head node root, write a function to split the linked list into
 * k consecutive linked list "parts".The length of each part should be as equal as possible: no two
 * parts should have a size differing by more than 1.This may lead to some parts being null.The parts
 * should be in order of occurrence in the input list, and parts occurring earlier should always
 * have a size greater than or equal parts occurring later.Return a List of ListNode's representing
 * the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 */
public class SplitLinkedListInParts {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public ListNode[] splitListToParts(ListNode root , int k){
        ListNode[] result=  new ListNode[k];
        ListNode p=root;
        int rootlen=0;
        while (p!=null){
            rootlen++;
            p=p.next;
        }
        int mod =rootlen % k;
        int size =rootlen / k;
        p=root;
        for (int i=0;p!=null && i<k;i++){
            result[i]=p;
            int cursize=size+(i<mod?1:0);
            for (int j=0;j<cursize-1;j++){
                p=p.next;
            }
            //砍断
            ListNode next=p.next;
            p.next=null;
            p=next;
        }
        return result;
    }

}
