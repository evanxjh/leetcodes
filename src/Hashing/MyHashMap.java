package Hashing;



/**
 * @author EvanHsia
 * @ClassName DesignHashMap.java
 * @Description No.706 Easy
 * @createTime 2019-09-24- 22:37
 */
public class MyHashMap {
    private ListNode[] table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table=new ListNode[10000];
    }

    private int getIndex(int key){
        return Integer.hashCode(key) % table.length;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getIndex(key);
        if (table[index]==null){
            table[index]=new ListNode(-1,-1);
        }
        ListNode head=table[index];
        while (head.next!=null){
            if (head.next.key==key){
                head.next.val=value;
                break;
            }else {
                head=head.next;
            }
        }
        if (head.next==null){
            head.next=new ListNode(key,value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getIndex(key);
        if (table[index]==null){
            return -1;
        }
        ListNode head=table[index];
        while (head.next!=null){
            if (head.next.key==key){
                return head.next.val;
            }else {
                head=head.next;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=getIndex(key);
        if (table[index]==null){
            return;
        }
        ListNode head=table[index];
        while (head.next!=null && head.next.key!=key){
            head=head.next;
        }
        if (head.next!=null){
            head.next=head.next.next;
        }
        return;
    }

    private class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
