package StackAndQueue;

import java.util.Stack;

/**
 * @program: leetcodetrain
 * @description: No.20 Easy
 * @author: EvenHsia
 * @create: 2019-08-02 23:12
 **/
public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()){
            if (c=='(' || c=='[' || c=='{'){
                stack.push(c);
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                char toremove=stack.peek();
                boolean b1= c==')' && toremove=='(';
                boolean b2= c==']' && toremove=='[';
                boolean b3= c=='}' && toremove=='{';
                if (b1||b2||b3){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
