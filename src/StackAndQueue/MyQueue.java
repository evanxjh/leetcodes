package StackAndQueue;

import java.util.Stack;

/**
 * @program: leetcodetrain
 * @description: No.232 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 17:27
 **/
public class MyQueue {
    private int front;                        //记录in中栈底元素
    private Stack<Integer> in=new Stack<>();
    private Stack<Integer> out=new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (in.isEmpty()){
            front=x;
        }
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return  out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!out.isEmpty()){
            return out.peek();
        } else {
            return front;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return  in.isEmpty()&&out.isEmpty();
    }
}
