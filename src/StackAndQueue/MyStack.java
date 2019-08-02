package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcodetrain
 * @description: No.225 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 22:32
 **/
//可以用两个队列，也可以用一个队列（push中将新插入元素逐步调整至队首）
public class MyStack {
    private Queue<Integer> in;
    /** Initialize your data structure here. */
    public MyStack() {
        in=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        in.add(x);
        int cursize=in.size();
        while (cursize-->1){
            in.add(in.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return  in.remove();
    }

    /** Get the top element. */
    public int top() {
        return in.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return in.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
