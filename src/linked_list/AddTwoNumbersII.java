package linked_list;

/**
 * @program: leetcodetrain
 * @description: No.445 Medium
 * @author: EvenHsia
 * @create: 2019-07-29 14:47
 **/

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    private int addcarry;
    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
            this.next=null;
        }
    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Stack<Integer> stackl1=bulid(l1);
        Stack<Integer> stackl2=bulid(l2);
        ListNode sentinel=new ListNode(-1);
        int carry=0;
        //头插法
        while (!stackl1.empty() || !stackl2.empty() || carry!=0) {
            int num1 = stackl1.empty() ? 0 : stackl1.pop();
            int num2 = stackl2.empty() ? 0 : stackl2.pop();
            int sum = num1 + num2 + carry;
            ListNode current = new ListNode(sum % 10);
            carry = sum / 10;
            current.next = sentinel.next;
            sentinel.next=current;
        }
        return sentinel.next;
    }

    private Stack<Integer> bulid(ListNode list){
        Stack<Integer> result=new Stack<>();
        while (list!=null){
            result.push(list.val);
            list=list.next;
        }
        return result;
    }

    //recurse version
    public ListNode addTwonumbers(ListNode l1,ListNode l2){
        addcarry=0;
        int len1=0,len2=0;
        ListNode p=l1;
        while (p!=null){
            len1++;
            p=p.next;
        }

        p=l2;
        while (p!=null){
            len2++;
            p=p.next;
        }
        p=addHelper(l1,len1,l2,len2);
        if (addcarry==0){
            return p;
        }else{
            ListNode newhead=new ListNode(addcarry);
            newhead.next=p;
            return newhead;
        }
    }

    private ListNode addHelper(ListNode l1,int len1,ListNode l2,int len2){
        if (len1==0 || len2==0) return null;
        ListNode current=new ListNode(0);
        int sum=0;
        if (len1>len2){
            current.next=addHelper(l1.next,len1-1,l2,len2);
            sum=l1.val+addcarry;
        } else if (len1<len2){
            current.next=addHelper(l1,len1,l2.next,len2-1);
            sum=l2.val+addcarry;
        }else {
            current.next=addHelper(l1.next,len1-1,l2.next,len2-1);
            sum=l1.val+l2.val+addcarry;
        }
        current.val=sum % 10;
        addcarry=sum /10;
        return current;
    }
}
