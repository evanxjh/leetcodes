package DivideAndConquer;

import java.util.PriorityQueue;

/**
 * @author EvanHsia
 * @ClassName MergeKSortedLists.java
 * @Description No.23 Hard
 * @createTime 2019-10-09- 11:04
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists){
        if (lists==null || lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((o1, o2) ->(o1.val-o2.val));
        for (int i=0;i<lists.length;i++){
            if (lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        ListNode sentinel=new ListNode(-1);
        ListNode cur=sentinel;
        while (!pq.isEmpty()){
            ListNode tmp=pq.poll();
            cur.next=tmp;
            cur=tmp;
            if (tmp.next!=null){
                pq.add(tmp.next);
            }
        }
        return sentinel.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }
    }
}
