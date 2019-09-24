package two_pointers;

import java.util.List;

/**
 * @author EvanHsia
 * @ClassName LinkedListCycleII.java
 * @Description No.142 Medium
 * @createTime 2019-09-24- 11:44
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head){
        if (head==null ||head.next==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                break;
            }
        }
        if (fast==null || fast.next==null){
            return null;
        }
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
