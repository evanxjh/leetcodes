package LogicProblems;

import linked_list.ListNode;

import java.util.Random;

/**
 * @author EvanHsia
 * @ClassName LinkedListRandomNode.java
 * @Description No.382 Medium
 * @createTime 2019-09-25- 20:42
 */
public class LinkedListRandomNode {
    private ListNode head;
    Random random=new Random();
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head=head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur=head;
        int res=cur.val;
        int i=1;
        while (cur!=null){
            if (random.nextInt(i)==0){
                res=cur.val;
            }
            cur=cur.next;
            i++;
        }
        return res;
    }
}
