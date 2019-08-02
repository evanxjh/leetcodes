package StackAndQueue;

import java.util.Stack;

/**
 * @program: leetcodetrain
 * @description: No.155 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 22:51
 **/
public class MinStack {
    private Stack<minNode> minstack;
    private int min;
    private class minNode{
        private int min;
        private int val;
        public minNode(int m,int v){
            this.min=m;
            this.val=v;
        }
    }
    /** initialize your data structure here. */
    public MinStack() {
        min=Integer.MAX_VALUE;
        minstack=new Stack<>();
    }

    public void push(int x) {
        min= Math.min(min,x);
        minstack.add(new minNode(min,x));
    }

    public void pop() {
        minstack.pop();
        min=minstack.isEmpty()?Integer.MAX_VALUE:minstack.peek().min;
    }

    public int top() {
        return minstack.peek().val;
    }

    public int getMin() {
        return min;
    }
}
